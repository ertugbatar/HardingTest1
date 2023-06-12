Feature:

  @wip
  Scenario: Job Application
    Given that I am looking at the company’s homepage
    And searching for an "Procurement Coordinator" job
    When I click on the "Apply" button
    Then I should be able to fill in the mandatory fields with the Basic data on the first page.
    And I should get the "<expected result>" when submitting the application.


  Scenario Outline: Job Application
    Given that I am looking at the company’s homepage
    And searching for an "Procurement Coordinator" job
    When I click on the "Apply" button
    Then I should be able to fill in the mandatory fields with the "<Test Case>" on the first page.
    And I should get the "<Expected result>" when submitting the application.

    Examples:
      | Test Case                                                   | Expected result                               |
      | Uploading PNG files                                         |           |
      | Uploading .BAT or EXE files                                 | Error message about the file format           |
      | Submitting with missing mandatory data                      | Fail submission, error messages at the fields |
      | Submitting with Word or PDF, all mandatory fields filled in | Success: Application complete                 |

