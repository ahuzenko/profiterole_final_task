Meta:
@browser = firefox

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: registered user opens add reciept page from home page
Given registered user is on the Home Page
When selects Рецепты->Создать Рецепт from main menu
Then create receipt page is opened

Scenario: registered user adds reciept with correct data
Given registered user is on add receipt page
When fills all the mandatory fields with 'testRecieptName','testRecieptDescription','0','15','100','1','1','соль','125','1','легкий','test steps of reciept 1'
Then reciept is added successfuly

Scenario: check mandatory fields are validated
Given registered user is on add receipt page
When leave all the fields empty and click add
Then reciept is not added, validation messages are displayed
