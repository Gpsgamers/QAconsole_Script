#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: UI sanity check on console

  #@tag1
  #Scenario: login the application
  #Given enter the URL
  #Then Login the application
  @tag2
  Scenario Outline: Check the values and Graphs in Recent activity on analytics page
    Given In plan type <PlanType>
    And on <TOP_users>
    When Verify if <Tabs> value exist
    And Verify if Graph not exist when <Tabs> <=0
    And Verify if Graph exist when Total <Tabs> >0

    @monthly->to->monthly
    Examples: 
      | PlanType     | Tabs                | TOP_users |
      | "All"        | "Total Messages"    |         1 |
      | "All"        | "Total Voice Calls" |         1 |
      | "All"        | "Total Video Cals"  |         1 |
      | "All"        | "Total Messages"    |         2 |
      | "All"        | "Total Voice Calls" |         2 |
      | "All"        | "Total Video Cals"  |         2 |
      | "All"        | "Total Messages"    |         3 |
      | "All"        | "Total Voice Calls" |         3 |
      | "All"        | "Total Video Cals"  |         3 |
      | "Trial"      | "Total Messages"    |         1 |
      | "Trial"      | "Total Voice Calls" |         1 |
      | "Trial"      | "Total Video Cals"  |         1 |
      | "Trial"      | "Total Messages"    |         2 |
      | "Trial"      | "Total Voice Calls" |         2 |
      | "Trial"      | "Total Video Cals"  |         2 |
      | "Trial"      | "Total Messages"    |         3 |
      | "Trial"      | "Total Voice Calls" |         3 |
      | "Trial"      | "Total Video Cals"  |         3 |
      | "Essentials" | "Total Messages"    |         1 |
      | "Essentials" | "Total Voice Calls" |         1 |
      | "Essentials" | "Total Video Cals"  |         1 |
      | "Essentials" | "Total Messages"    |         2 |
      | "Essentials" | "Total Voice Calls" |         2 |
      | "Essentials" | "Total Video Cals"  |         2 |
      | "Essentials" | "Total Messages"    |         3 |
      | "Essentials" | "Total Voice Calls" |         3 |
      | "Essentials" | "Total Video Cals"  |         3 |
      | "Growth"     | "Total Messages"    |         1 |
      | "Growth"     | "Total Voice Calls" |         1 |
      | "Growth"     | "Total Video Cals"  |         1 |
      | "Growth"     | "Total Messages"    |         2 |
      | "Growth"     | "Total Voice Calls" |         2 |
      | "Growth"     | "Total Video Cals"  |         2 |
      | "Growth"     | "Total Messages"    |         3 |
      | "Growth"     | "Total Voice Calls" |         3 |
      | "Growth"     | "Total Video Cals"  |         3 |
      | "Premium"    | "Total Messages"    |         1 |
      | "Premium"    | "Total Voice Calls" |         1 |
      | "Premium"    | "Total Video Cals"  |         1 |
      | "Premium"    | "Total Messages"    |         2 |
      | "Premium"    | "Total Voice Calls" |         2 |
      | "Premium"    | "Total Video Cals"  |         2 |
      | "Premium"    | "Total Messages"    |         3 |
      | "Premium"    | "Total Voice Calls" |         3 |
      | "Premium"    | "Total Video Cals"  |         3 |
  #@tag3
  #Scenario: Check the values and Graphs in Total message section in Analytics Overview
    #on analytics page
    #When verify if Total message value exist
    #And Verify if Graph not exist when Total message <=0
    #And Verify if Graph exist when Total message >0
#
  #Scenario Outline: Check the values and Graphs in New User section in Analytics Overview on analytics page
    #Given Select platform <Platform>
    #When verify if New users value exist
    #And Verify if Graph not exist when New users <=0
    #And Verify if Graph exist when New users >0
#
    #Examples: 
      #| "Platform" |
      #| "All"      |
      #| "Android"  |
      #| "iOS"      |
      #| "Web"      |
      #| "Others"   |
#
  #Scenario Outline: Check the values and Graphs in Total call Duration section in Analytics Overview on analytics page
    #Given Select calltype <Calltype>
    #When verify if Total Call Duration value exist
    #And Verify if Graph not exist when Total call duration <=0
    #And Verify if Graph exist when Total call duration >0
#
    #Examples: 
      #| "Calltype"    |
      #| "Total Calls" |
      #| "Voice Calls" |
      #| "Video Calls" |
#
  #Scenario Outline: Check the values and Graphs in Total calls section in Analytics Overview on analytics page
    #Given Select call <Call>
    #When verify if Total Calls value exist
    #And Verify if Graph not exist when Total calls <=0
    #And Verify if Graph exist when Total calls >0
#
    #Examples: 
      #| "Calltype"    |
      #| "Total Calls" |
      #| "Voice Calls" |
      #| "Video Calls" |
