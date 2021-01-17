package com.revature.bankapp

import com.revature.bookapp.cli.Cli

object Runner extends App{
    println("Bank App Running");
    val cli = new Cli();
    cli.menu();
}