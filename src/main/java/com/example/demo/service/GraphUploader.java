package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.demo.model.Node;
import com.example.demo.model.Route;
import com.example.demo.repository.NodeRepository;
import org.springframework.stereotype.Service;

@Service
public class GraphUploader {
    private static Map<Long, Map<Long, Long>> graph = new HashMap<>();
    private static List<Long> processed = new ArrayList<>();
    final NodeRepository nodeRepository;

    public GraphUploader(NodeRepository nodeRepository) {
        this.nodeRepository = nodeRepository;
    }

    private static Long findLowestCostNode(Map<Long, Long> costs) {
        Long lowestCost = Long.MAX_VALUE;
        Long lowestCostNode = null;
        for (Map.Entry<Long, Long> node : costs.entrySet()) {
            Long cost = node.getValue();
            if (cost < lowestCost && !processed.contains(node.getKey())) {
                lowestCost = cost;
                lowestCostNode = node.getKey();
            }
        }
        return lowestCostNode;
    }

    public void uploadGraph() {
        List<Node> allNodes = nodeRepository.findAll();
        for (Node node : allNodes) {
            if (!graph.containsKey(node.getPointFrom())) {
                graph.put(node.getPointFrom(), new HashMap<>());
            }
            graph.get(node.getPointFrom()).put(node.getPointTo(), node.getLength());
        }
    }

    public Long findShortestRoute(Route route) {
        Map<Long, Long> costs = new HashMap<>();
        costs.put(route.getPointTo(), Long.MAX_VALUE);
        if (graph.containsKey(route.getPointFrom())) {
            costs.putAll(graph.get(route.getPointFrom()));
        }
        Long node = findLowestCostNode(costs);
        while (node != null) {
            Long cost = costs.get(node);
            Map<Long, Long> neighbors = graph.get(node);
            if (neighbors != null) {
                for (Long neighbor : neighbors.keySet()) {
                    Long newCost = cost + neighbors.get(neighbor);
                    if (!costs.containsKey(neighbor)) {
                        costs.put(neighbor, newCost);
                    } else {
                        if (costs.get(neighbor) > newCost) {
                            costs.put(neighbor, newCost);
                        }
                    }
                }
            }
            processed.add(node);
            node = findLowestCostNode(costs);
        }
        processed.clear();
        return costs.get(route.getPointTo());
    }
}
