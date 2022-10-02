package controllers;

import models.Branch;
import services.UiService;
import services.Utils;

import java.util.List;

public class UiController {
    private final UiService uiService;
    private final Utils utils;

    public UiController(UiService uiService, Utils utils) {
        this.uiService = uiService;
        this.utils = utils;
    }

    /**
     * This function parses the displayParams, gets the branch and calls uiService for displaying.
     *
     * @param displayParameters a list of string containing display parameters
     * @param branchList list of branches
     */
    public void displayVehicles(List<String> displayParameters, List<Branch> branchList) {
        String branchId = displayParameters.get(1);
        Long startTime = Long.parseLong(displayParameters.get(2));
        Long endTime = Long.parseLong(displayParameters.get(3));

        Branch branch = utils.getBranchFromBranchName(branchList, branchId);
        uiService.displayVehicles(branch, startTime, endTime);
    }
}
