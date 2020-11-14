package com.example.demo.service.impl;

import com.example.demo.controllers.NodesLoaderController;
import com.example.demo.service.CommandsHandler;
import org.springframework.stereotype.Service;

@Service
public class UpdateNodesInDBCommand implements CommandsHandler {
    private final NodesLoaderController nodesLoaderController;

    public UpdateNodesInDBCommand(NodesLoaderController nodesLoaderController) {
        this.nodesLoaderController = nodesLoaderController;
    }

    @Override
    public void execute() {
        nodesLoaderController.updateNodesInDB();
    }
}
