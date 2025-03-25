package doo;

public record WithdrawRequestModel(
        String sourceNumber,
        String sourceBranch,
        String password,
        String destinationNumber,
        String destinationBranch,
        double amount
) { }
