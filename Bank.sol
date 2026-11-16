// SPDX-License-Identifier: MIT
pragma solidity ^0.8.20;

contract BankAccount {

    uint balance =0;
    address public accOwner;

    constructor(){
        accOwner = msg.sender;


    }

    // Deposit Ether
    function deposit() public payable {
        require(msg.sender == accOwner,"You are not owner");
        require(msg.value > 0, "Deposit must be greater than zero");
        balance+=msg.value;
    }

    // Withdraw Ether
    function withdraw() public payable  {
        require(msg.value > 0, "Amount must be greater than zero");
        require(balance >= msg.value , "Low balance");
        balance-= msg.value;
    }

    // Show balance
    function showBalance() public view returns (uint256) {
        return balance;
    }
}