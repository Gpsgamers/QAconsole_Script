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

  @tag1
  Scenario: login the application
    Given enter the URL
    Then Login the application

  @tag2
  Scenario Outline: Check the values and Graphs in Recent activity on analytics page
    Given In plan type <PlanType>
    When Verify if Graph not exist when Total message <=0
    And Verify if Graph exist when Total message >0
    When Verify if Graph not exist when Total Voice calls <=0
    And Verify if Graph exist when Total Voice calls >0
    When Verify if Graph not exist when Total Video calls <=0
    And Verify if Graph exist when Total Video calls >0

    Examples: 
      | PlanType   |
      | All        |
      | Trial      |
      | Essentials |
      | Growth     |
      | Premium    |

  @tag3
  Scenario: Check the values and Graphs in Total message section in Analytics Overview
    on analytics page

    When Verify if Graph not exist when Total message <=0
    And Verify if Graph exist when Total message >0

  Scenario Outline: Check the values and Graphs in New User section in Analytics Overview on analytics page
    Given Select platform <Platform>
    When Verify if Graph not exist when New users <=0
    And Verify if Graph exist when New users >0

    Examples: 
      | Platform |
      | All      |
      | Android  |
      | iOS      |
      | Web      |
      | Others   |

  Scenario Outline: Check the values and Graphs in Total call Duration section in Analytics Overview on analytics page
    Given Select calltype <Calltype>
    When Verify if Graph not exist when Total call duration <=0
    And Verify if Graph exist when Total call duration >0

    Examples: 
      | Calltype    |
      | Total Calls |
      | Voice Calls |
      | Video Calls |

  Scenario Outline: Check the values and Graphs in Total calls section in Analytics Overview on analytics page
    Given Select call <Call>
    When Verify if Graph not exist when Total calls <=0
    And Verify if Graph exist when Total calls >0

    Examples: 
      | Call        |
      | Total Calls |
      | Voice Calls |
      | Video Calls |
