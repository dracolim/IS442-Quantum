# IS442 x Quantum Project by Team 8

![example workflow](https://img.shields.io/badge/Build%20In-HTML%2C%20CSS%20%2C%20Vue.js%2C%20Java-brightgreen)
![example workflow](https://img.shields.io/badge/Build%20With-Spring%20Boot-blue)
![example workflow](https://img.shields.io/badge/Database-SQL-red)

#### Group Memebers
* Lim Bei Ling Cheryl
* Faisal Samudra
* Cher Kheem Thong
* Wisely Kwek
* Liao JiaXiong
* Natalie Chan
* FuWei Tian

## Type of Users
1. Vendor [ [link](#vendor) ]
2. Admin [ [link](#admin) ]
3. Approver [ [link](#approver) ]

## Setting Up The Project (Spring Boot Application)
1. Ensure that you have WAMP / MAMP installed and running
2. Go to `backend/src/main/resources/application.properties` and edit the  credentials for `spring.datasource.username` and `spring.datasource.password` to your own credentials for your WAMP/MAMP server
3. Create a database in the WAMP/MAMP server with the name `qlvmsdb`
4. Once created, run the `build.bat` file in the terminal. The `build.bat` file will download apache-maven-3.9.1-bin.zip and set it to your local maven environment variable. The `mvn spring-boot:run` command will also be executed and the Spring Boot application should load all the necessary data into the database. 
<br>
<img width="500" alt="Screenshot 2023-03-27 at 2 41 29 PM" src="https://user-images.githubusercontent.com/89119401/229340309-9540cbd6-7a99-4e6b-9c78-47cc0769e60c.png">
## Accessing the Front-End Pages
- The front-end pages are located in the `frontend` folder, explanation for the respective pages are shown below:

### Login Page
<code>login_home.html</code>
* Users can login to their respective accounts with their email and password. There are total 3 user types (Approver, Admin, Vendor).
* This login page will idenitfy which users belongs to which user type, and bring them to their respective homepage. <br>
<img width="500" alt="Screenshot 2023-03-27 at 2 41 29 PM" src="https://user-images.githubusercontent.com/85498185/227860749-a10d9b96-cd32-45f3-be2f-09d655c5e450.png">

## Vendor 
### Homepage
<code>Vendor_workflow.html</code>
* This is the Vendor's homepage
* It displays all the pending workflows (Workflows that have formStatuses "REQUESTED") that requires Vendors to fill in the forms. 
* Vendors can either click on the table row or the icon in the forms column to go to the respective workflow page. <br>
<img width="500" alt="Screenshot 2023-03-27 at 2 49 09 PM" src="https://user-images.githubusercontent.com/85498185/227862206-9779825d-acae-4d3e-8ff8-cb879d5599c2.png">

#### Select individual workflow
<ins>Steps to select individual workflow<ins> <br>
 1. From <code>Vendor_workflow.html</code>, Vendors can either click on the table row or the icon in the forms column.
 2. After selecting, it will bring the vendors to <code>Vendor_form.html</code> where it will display all the forms that belongs to that particular workflow <br>
 3. **Form Status:** "COMPLETED" and "INCOMPLETE"
    * By Default, if Vendor have not submitted form, the staus will be "INCOMPLETE"
    * If Vendor Submits form, the status will be changed from "INCOMPLETE" to "COMPLETED"
    * If Admin requests Vendor to submit/update form again, the status will be changed to "INCOMPLETE"
<img width="500" height ="320" alt="Screenshot 2023-03-27 at 2 56 27 PM" src="https://user-images.githubusercontent.com/85498185/227863633-f3b29447-34a7-47e3-ac7c-1691238f3bed.png">

#### Select individual form
<ins>Steps to select individual form<ins> <br>
 1. From <code>Vendor_workflow.html</code>, Vendors can either click on the table row or the icon in the forms column.
 2. After selecting, it will bring the vendors to <code>Vendor_form.html</code> where it will display all the forms that belongs to that particular workflow <br>
 3. From <code>Vendor_form.html</code>, select any forms that is displayed. It will lead to the <code>Vendor_form_sequence.html</code> where all the questions from the form will be shown <br>
<img width="500" alt="Screenshot 2023-03-27 at 2 57 19 PM" src="https://user-images.githubusercontent.com/85498185/227863829-a4dfc614-5c81-42c3-a13c-2b1159c6d747.png">
  
## Admin
### Homepage (Pending Workflows Tab)
<code>Admin_home.html</code>
* This is the Admin's homepage
* It displays all the pending workflows (workflow with status: IN PROGRESS) that requires the Admins to validate the form after Vendor's submission 
* Admins can click on the table row to go to the respective pending workflows page <code>Admin_individual_pendingwf.html</code> <br>
<img width="500" alt="Screenshot 2023-03-27 at 3 04 45 PM" src="https://user-images.githubusercontent.com/85498185/227865390-993ffda1-6b2f-48ba-b5a1-fad8544872fd.png">

#### Select individual pending workflow 
<ins>Steps to select individual workflow<ins> <br>
1. From <code>Admin_home.html</code>, Admins can click on the table row
2. After selecting, it will bring the Admins to <code>Admin_individual_pendingwf.html</code> where it will display all the forms that belong to that pending workflow <br>
<img width="500" alt="Screenshot 2023-03-27 at 3 07 43 PM" src="https://user-images.githubusercontent.com/85498185/227866026-3068f666-c4ac-446e-8155-0781b12b62a2.png">

#### Validate Forms
<ins>Steps to validate form<ins> <br>
1. From <code>Admin_home.html</code>, Admins can click on the table row
2. After selecting, it will bring the Admins to <code>Admin_individual_pendingwf.html</code> where it will display all the forms that belong to that pending workflow <br>
3. At <code>Admin_individual_pendingwf.html</code>, Admins can select "APPROVED" or "NOT APPROVED" from the dropdown menu in the Approval column. <br>
<img width="500" alt="Screenshot 2023-03-22 at 4 16 23 PM" src="https://user-images.githubusercontent.com/85498185/226840559-a2719df8-4454-4daf-9cf2-502b81be6db7.png"><br>
4. **Scenario 1:** if Admins selects "APPROVED", the status (Status column) will change from "PENDING" to "VALIDATED". <br>
<img width="500" alt="Screenshot 2023-03-22 at 4 17 37 PM" src="https://user-images.githubusercontent.com/85498185/226840879-a51671a7-17f3-45fa-936a-0f6b6ea5bad8.png"> <br>
5. **Scenario 2:** if Admins selects "NOT APPROVED", the status (Status column) will change from "PENDING" to "REQUESTED" <br>
<img width="500" style ="margin-left = 10px" alt="Screenshot 2023-03-22 at 4 15 14 PM" src="https://user-images.githubusercontent.com/85498185/226840328-b8fe5b11-1f30-4b35-b2d1-d2152cf4682c.png"> <br>

#### Admin Submit Forms
<ins>Steps to submit form<ins> <br>
1. From <code>Admin_home.html</code>, Admins can click on the table row
2. After selecting, it will bring the Admins to <code>Admin_individual_pendingwf.html</code> where it will display all the forms that belong to that pending workflow <br>
3. At <code>Admin_individual_pendingwf.html</code>, Admin can click on the table row to select the forms they want to view or submit
4. After selecting, it will bring the Admins to <code>Admin_form_sequence.html</code> where it will display all the questions and answers submitted
5. Admin can check the form as well as fill in the required questions (eg: Admin Evaluation) and submit form. <br>
<img width="500" alt="Screenshot 2023-03-27 at 3 14 51 PM" src="https://user-images.githubusercontent.com/85498185/227867641-6b40c7d9-0b21-4afa-beab-8fa5d82dd7d9.png">

### Workflows Tab
<code>Admin_workflow.html</code>
* This is the Admin's overview of all the existing workflows 
* This page will show all the completed, in-progress and rejected workflows 
* Admin can either check sequence, edit and delete workflows
<img width="500" alt="Screenshot 2023-03-27 at 3 19 00 PM" src="https://user-images.githubusercontent.com/85498185/227868548-49eca8e8-92fc-4666-8699-7945e219a90b.png">

#### Assign New Workflow 
<ins>Steps to Assign New Workflow</ins><br>
1. At <code>Admin_workflow.html</code>, click on "Assign new workflow" button. A pop up will be shown on the screen.
2. Fill in the required details and submit
3. Once submitted, the new workflow will be shown on the table.
4. **Error Handling**:
    * Scenario 1: Empty Inputs
<img width="500" alt="Screenshot 2023-03-27 at 3 38 56 PM" src="https://user-images.githubusercontent.com/85498185/227873294-26aae6b5-6c21-41d5-8502-034d78a16032.png">

#### Check Sequence 
<ins>Steps to Check Workflow Sequence</ins><br>
1. From <code>Admin_workflow.html</code>, Admin can either click on the table rows or the document icon in the "check sequence" column
2. It will lead to <code>Admin_workflow_sequences.html</code>, where it will show all the forms and it's statuses that belongs to that workflow <br>
<img width="500" alt="Screenshot 2023-03-27 at 3 32 52 PM" src="https://user-images.githubusercontent.com/85498185/227871805-731e95a4-2b6d-4073-b35f-de8a55b327cc.png">

#### Edit Workflow 
<ins>Steps to Edit Workflow</ins><br>
1. At <code>Admin_workflow.html</code>, click on the icon in the "Edit" column. A pop up will be shown on the screen.
2. Edit the required fields and submit 
3. Once submitted, the workflow will be updated with the new details
4. **Error Handling**:
    * Scenario 1: Empty Inputs
<img width="500" alt="Screenshot 2023-03-27 at 3 44 37 PM" src="https://user-images.githubusercontent.com/85498185/227874539-51851af3-650a-4930-958d-cecf6ae2202f.png">

#### Delete Workflow
<ins>Steps to Delete Workflow</ins><br>
1. At <code>Admin_workflow.html</code>, click on the icon in the "Delete" column. 
2. After clicking, it will delete the workflow

#### Assign New Forms to Workflow
<ins>Steps to Assign New Forms to Workflow</ins><br>
1. From <code>Admin_workflow.html</code>, Admin can either click on the table rows or the document icon in the "check sequence" column
2. From <code>Admin_workflow_sequences.html</code>, click on "ASSIGN NEW FORMS" button, a pop up will be shown on the screen
3. Select on the forms, and click "Submit" button. The forms will then be added to the workflow.
<img width="500" alt="Screenshot 2023-03-27 at 3 50 52 PM" src="https://user-images.githubusercontent.com/85498185/227875948-715c1223-7b3f-450e-8f02-9324433c7fe4.png">

#### Delete Forms from Workflow
<ins>Steps to Delete Form from Workflow</ins><br>
1. From <code>Admin_workflow.html</code>, Admin can either click on the table rows or the document icon in the "check sequence" column
2. At <code>Admin_workflow_sequences.html</code>, click on the icon in the "Delete" column. 
3. After clicking, it will delete the form from workflow.

#### View Form
<ins>Steps to View Form</ins><br>
1. From <code>Admin_workflow.html</code>, Admin can either click on the table rows or the document icon in the "check sequence" column
2. At <code>Admin_workflow_sequences.html</code>, click on the any table rows. 
3. It will lead to <code>Admin_form_sequences2.html</code>, where it will show all the questions and answers from the fomr
4. Admin CANNOT submit or edit form. If Admin would like to do so, they have to go to [click on this link](#admin-submit-forms)

#### Export Form
<ins>Steps to Export Form</ins><br>
1. From <code>Admin_workflow.html</code>, Admin can either click on the table rows or the document icon in the "check sequence" column
2. From <code>Admin_workflow_sequences.html</code>, click on the any table rows. 
3. At <code>Admin_form_sequences2.html</code>, click on "EXPORT" button
4. The form PDF will be automatically downloaded to the desktop
<img width="500" alt="Screenshot 2023-03-27 at 4 07 33 PM" src="https://user-images.githubusercontent.com/85498185/227880137-d8ac5024-c366-4836-ab93-221fee2512e7.png">

### Accounts Tab
<code>Admin_accounts.html</code>
* This is the Admin's view of the accounts page
* It displays all the accounts of all 3 types (Admin, Approver & Vendor) registered in the system.
* An Admin can create an account of any 1 of the 3 types by clicking either "CREATE VENDOR ACCOUNT", "CREATE APPROVER ACCOUNT" or "CREATE ADMIN ACCOUNT".
* An Admin can delete any existing accounts by clicking the delete button that is represented by a trash can icon.
* An Admin can update any existing accounts by clicking the update button that is represented by a document & pen icon. <br>
<img width="500" alt="admin accounts page" src="https://user-images.githubusercontent.com/89073137/227719987-8377f9fe-bb4d-42a9-8e30-492aa51d4a0f.PNG">

#### Creating an Account
<ins>Steps to create a vendor account<ins> <br>
<ins>For creating Admin & Approver accounts, click the appropriate "CREATE _____ ACCOUNT" under step 1 and follow the rest of the steps. <ins> <br>
1. At <code>Admin_accounts.html</code>, Admins can click on "CREATE VENDOR ACCOUNT" located at the bottom right corner. <br>
2. After clicking, a modal will appear that will allow the Admin to enter the necessary details to create the account. <br>
3. After filling in the information, the Admin can click on the blue Save button that's located at the bottom of the modal. <br>
4. If no fields are left empty and all fields are valid, the account is now successfully created. 
<img width="500" alt="create vendor account admin" src="https://user-images.githubusercontent.com/89073137/227720523-07292b23-a87c-4c08-b2c8-00e853ddae75.PNG"><br>

#### Updating an Account
<ins>Steps to update an account<ins> <br>
<ins>Example given is for updating Vendor account, but the steps apply to all 3 types of accounts<ins> <br>
1. At <code>Admin_accounts.html</code>, under a particular account, Admins can click on the update button (represented by a document & pen icon) associated to the account to update account information. <br>
2. After clicking, a modal will appear that will allow the Admin to edit the necessary details to update the account. <br>
3. After filling in the information, the Admin can click on the blue Save button that's located at the bottom of the modal. <br>
4. If no fields are left empty and all fields are valid, the account is now successfully updated. 
<img width="500" alt="update account" src="https://user-images.githubusercontent.com/89073137/227721067-9af61ef8-09ba-4dc4-8fd1-6a12fb88ed4f.PNG"><br>
  
### Forms Tab
<code>Admin_form.html</code><br>
* This page shows all the forms that exists 
* Admin can either view , edit or delete form <br>
<img width="500" alt="Screenshot 2023-03-27 at 4 23 54 PM" src="https://user-images.githubusercontent.com/85498185/227884265-1a656b8e-b73a-4911-9e6f-456afb0b81ce.png">

#### Delete Form
<ins>Steps to Delete Form<ins><br>
1. At <code>Admin_form.html</code>, click on the icon in "DELETE" column to delete form
2. After clicking, the form will be removed from the table

#### View Question Details
<ins>Steps to View Question Details<ins><br>
1. At <code>Admin_form.html</code>, either click on the icon in "FORM DOCUMENT" column or any table rows
2. It will lead to <code>Admin_Individual_form.html</code>, where all the questions details (Eg: Field Type, Field Name) will be shown

#### Create New Form
<ins>Steps to Create New Form<ins><br>
1. At <code>Admin_form.html</code>, click on "CREATE NEW FORM" button. A pop up will be shown on the screen
2. Fill in the Form Name field and click on the "Submit" button
3. Form will be created and added to the table 
<img width="500" alt="Screenshot 2023-03-27 at 4 27 33 PM" src="https://user-images.githubusercontent.com/85498185/227885310-416466fe-4e38-4bbc-bb93-91f4aede46af.png">

#### Edit Form Name
<ins>Steps to Edit Form Name<ins><br>
1. At <code>Admin_form.html</code>, either click on the icon in "FORM DOCUMENT" column or any table rows
2. It will lead to <code>Admin_Individual_form.html</code>, where all the questions details (Eg: Field Type, Field Name) will be shown
3. Click on the Input beside Form Name, and fill in the new form name. It will edit the form name accordinly
<img width="500" alt="Screenshot 2023-03-27 at 4 49 28 PM" src="https://user-images.githubusercontent.com/85498185/227891252-1a8adf22-6962-448c-9351-aaf5402e2800.png">

#### Edit Section Title, ID, Description
<ins>Steps to Edit Section Title, ID, Description<ins><br>
1. At <code>Admin_form.html</code>, either click on the icon in "FORM DOCUMENT" column or any table rows
2. It will lead to <code>Admin_Individual_form.html</code>, where all the questions details (Eg: Field Type, Field Name) will be shown
3. At <code>Admin_Individual_form.html</code>,
    * **Section Title**: Click on the Input from "SECTION TITLE" column and edit accordingly
    * **Section Description**: Click on the Input from "SECTION DESCRIPTION" column and edit accordingly
    * **Section ID**: Click on the dropdown and select the section Ids from "SECTION ID" column
<img width="500" alt="Screenshot 2023-03-27 at 4 48 24 PM" src="https://user-images.githubusercontent.com/85498185/227891052-79895b3d-e287-4dc4-b700-c5dcf861cb77.png">

#### Edit Field Name, Field Type, Input Options, Required
<ins>Steps to Edit Field Name, Field Type, Input Options, Required<ins><br>
1. At <code>Admin_form.html</code>, either click on the icon in "FORM DOCUMENT" column or any table rows
2. It will lead to <code>Admin_Individual_form.html</code>, where all the questions details (Eg: Field Type, Field Name) will be shown
3. At <code>Admin_Individual_form.html</code>,
  * **Field Name**: Click on the Input from "FIELD NAME" column and edit accordingly
  * **Field Type**: Click on the dropdown and select the field types 
  * **Required**: Click on the dropdown and select the option (True: it is required; False: It is not required)
  * **Input Options**:
      * "Edit Options" will only appear if the field types are either <ins>Radio<ins> or <ins>Checkbox<ins>
      * To Edit the Options:
        1. Click on the "Edit Options"; A pop up will be shown on the screen
        2. Select the Number of Input Options
        3. Click on the "->"
        4. The options input will be shown; fill it in and click submit
        5. The new options will be shown in the "INPUT OPTIONS" column
        5. **Error Handling**: 
            * Scenario 1: Input cannot be empty
            * Scenario 2: Input cannot be the same 
        6. (EXTRA) if "others" is added into the Input Options, it will automatically create a "(Others) ____[Field Name]___ " question and added to the section that belongs to that question.
<img width="500" alt="Screenshot 2023-03-27 at 4 52 19 PM" src="https://user-images.githubusercontent.com/85498185/227892044-e0620f7b-08d2-48f4-96cc-a497957170b0.png">

#### Delete Field
<ins>Steps to Delete Field<ins><br>
1. At <code>Admin_form.html</code>, either click on the icon in "FORM DOCUMENT" column or any table rows
2. It will lead to <code>Admin_Individual_form.html</code>, where all the questions details (Eg: Field Type, Field Name) will be shown
3. At <code>Admin_Individual_form.html</code>, click on the icon in "DELETE" column to delete the field.

#### Create New Field/Question 
<ins>Steps to Create New Field/Question<ins><br>
1. At <code>Admin_form.html</code>, either click on the icon in "FORM DOCUMENT" column or any table rows
2. It will lead to <code>Admin_Individual_form.html</code>, where all the questions details (Eg: Field Type, Field Name) will be shown
3. At <code>Admin_Individual_form.html</code>, click on "CREATE NEW FIELDS" button. A pop up will be shown
4. Admin can either add the new field to a existing section or to a new section.
    * If Admin wants to add new field to the new section, click on "Add New Sections" button. A New Section ID will automatically be assigned, and the Section Title and Description will be shown for Admin to fill in
    <img width="500" alt="Screenshot 2023-03-27 at 5 06 10 PM" src="https://user-images.githubusercontent.com/85498185/227895611-05ffb825-e388-4829-8559-345a6d548129.png"> <br>
    * If Admin wants to add new field to an existing section, click on "Add Existing Sections"
    <img width="500" alt="Screenshot 2023-03-27 at 5 07 13 PM" src="https://user-images.githubusercontent.com/85498185/227895896-d53d475f-c42c-4394-a6ed-5523e171727a.png"> <br>
    * However, if there is no existing sections, the "Add to Existing Sections" button will be disabled.
5. **Error Handling**: 
    * Scenario 1: Input cannot be empty
    * Scenario 2: Input cannot be the same 
6. (EXTRA) if "others" is added as an Input Options, it will automatically create a "(Others) ____[Field Name]___ " question and added to the section that belongs to that question.

#### View Form Format
<ins>Steps to View Form Format<ins><br>
1. At <code>Admin_form.html</code>, either click on the icon in "FORM DOCUMENT" column or any table rows
2. It will lead to <code>Admin_Individual_form.html</code>, where all the questions details (Eg: Field Type, Field Name) will be shown
3. At <code>Admin_Individual_form.html</code>, click on "VIEW FORM" button
4. It will lead to <code>Admin_overview_form.html</code>, where Admin can get an overview of how the form will look like
<img width="500" alt="Screenshot 2023-03-27 at 5 10 38 PM" src="https://user-images.githubusercontent.com/85498185/227896652-bcec39b7-51ef-41e0-9a24-b646bc09a9f2.png">

#### (EXTRA) Adjust Table Column Size
<ins>Steps to Adjust Table Column Size<ins><br>
1. At <code>Admin_Individual_form.html</code>, click and drag the lines in between the columns (applicable for table header and row 1 only)
2. Once it is dragged, the table column will change its size accordingly
<img width="500" alt="Screenshot 2023-03-27 at 6 10 38 PM" src="https://user-images.githubusercontent.com/85498185/227912594-1b4ba8eb-5f42-48a9-9a23-4422c46dadca.png">

## Approver
### Homepage (Validated Workflows Tab)
<code>Approver_home.html</code>
* This is the Approver's homepage
* It displays all the validated workflows (Form status is "VALIDATED") that requires the Approvers to validate the form after Admin Approval
* Approvers can click on the table row to go to the respective validated workflows page <code>Approver_individual_pendingwf.html</code> <br>
<img width="500" alt="Screenshot 2023-03-27 at 5 21 08 PM" src="https://user-images.githubusercontent.com/85498185/227899412-83058262-876e-462a-bf91-6a03734a31e4.png">

#### Select individual pending workflow 
<ins>Steps to select individual workflow<ins> <br>
1. From <code>Approver_home.html</code>, Approvers can click on the table row
2. After selecting, it will bring the Approvers to <code>Approver_individual_pendingwf.html</code> where it will display all the forms that belong to that validated workflow <br>
<img width="500" alt="Screenshot 2023-03-27 at 3 07 43 PM" src="https://user-images.githubusercontent.com/85498185/227866026-3068f666-c4ac-446e-8155-0781b12b62a2.png">

#### Validate Forms
<ins>Steps to validate form<ins> <br>
1. From <code>Approver_home.html</code>, Approvers can click on the table row
2. After selecting, it will bring the Approvers to <code>Approver_individual_pendingwf.html</code> where it will display all the forms that belong to that validated workflow <br>
3. At <code>Approver_individual_pendingwf.html</code>, Approvers can select "APPROVED" or "NOT APPROVED" from the dropdown menu in the Approval column. <br>
<img width="500" alt="Screenshot 2023-03-27 at 5 36 30 PM" src="https://user-images.githubusercontent.com/85498185/227903469-85c7dd99-d714-49c9-92a9-efe1e9efc302.png">
4. **Scenario 1:** if Approvers selects "APPROVED", the status (Status column) will change from "VALIDATED" to "APPROVED" <br>
<img width="500" alt="Screenshot 2023-03-27 at 5 37 42 PM" src="https://user-images.githubusercontent.com/85498185/227903760-199f32c4-29a1-40d4-8aee-ba8042c88303.png"> <br>
5. **Scenario 2:** if Approvers selects "NOT APPROVED", the status (Status column) will change from "VALIDATED" to "REJECTED" <br>
<img width="500" alt="Screenshot 2023-03-27 at 5 38 09 PM" src="https://user-images.githubusercontent.com/85498185/227903882-e70692f8-f19d-4478-a181-f052f5255f7f.png"> <br>

#### Approver Submit Forms
<ins>Steps to submit form<ins> <br>
1. From <code>Approver_home.html</code>, Approvers can click on the table row
2. After selecting, it will bring the Approvers to <code>Approver_individual_pendingwf.html</code> where it will display all the forms that belong to that validated workflow <br>
3. At <code>Approver_individual_pendingwf.html</code>, Approvers can click on the table row to select the forms they want to view or submit
4. After selecting, it lead to <code>Approver_form_sequence.html</code> where it will display all the questions and answers submitted 
5. Approver can check the form as well as fill in the required questions (eg: Admin Evaluation) and submit form. <br>
<img width="500" alt="Screenshot 2023-03-27 at 3 14 51 PM" src="https://user-images.githubusercontent.com/85498185/227867641-6b40c7d9-0b21-4afa-beab-8fa5d82dd7d9.png">

### Workflows Tab
<code>Apporver_workflow.html</code>
* This is the Approver's overview of all the existing workflows 
* This page will show all the completed, in-progress and rejected workflows 
* Approver can either check sequence, edit and delete workflows
<img width="500" alt="Screenshot 2023-03-27 at 5 45 17 PM" src="https://user-images.githubusercontent.com/85498185/227905642-00e89e5f-70bd-4074-a647-88e751d51168.png">

#### Assign New Workflow 
<ins>Steps to Assign New Workflow</ins><br>
1. At <code>Approver_workflow.html</code>, click on "Assign new workflow" button. A pop up will be shown on the screen.
2. Fill in the required details and submit
3. Once submitted, the new workflow will be shown on the table.
4. **Error Handling**:
    * Scenario 1: Empty Inputs
<img width="500" alt="Screenshot 2023-03-27 at 3 38 56 PM" src="https://user-images.githubusercontent.com/85498185/227873294-26aae6b5-6c21-41d5-8502-034d78a16032.png">

#### Check Sequence 
<ins>Steps to Check Workflow Sequence</ins><br>
1. From <code>Approver_workflow.html</code>, Approver can either click on the table rows or the document icon in the "check sequence" column
2. It will lead to <code>Approver_workflow_sequences.html</code>, where it will show all the forms and it's statuses that belongs to that workflow <br>
<img width="500" alt="Screenshot 2023-03-27 at 5 46 18 PM" src="https://user-images.githubusercontent.com/85498185/227905936-ddc49d88-42bd-4b95-b038-2739e91fa09a.png">

#### Edit Workflow 
<ins>Steps to Edit Workflow</ins><br>
1. At <code>Approver_workflow.html</code>, click on the icon in the "Edit" column. A pop up will be shown on the screen.
2. Edit the required fields and submit 
3. Once submitted, the workflow will be updated with the new details
4. **Error Handling**:
    * Scenario 1: Empty Inputs
<img width="500" alt="Screenshot 2023-03-27 at 5 46 52 PM" src="https://user-images.githubusercontent.com/85498185/227906082-63561443-d611-4165-93dd-d4e3be5291af.png">

#### Delete Workflow
<ins>Steps to Delete Workflow</ins><br>
1. At <code>Approver_workflow.html</code>, click on the icon in the "Delete" column. 
2. After clicking, it will delete the workflow

#### Assign New Forms to Workflow
<ins>Steps to Assign New Forms to Workflow</ins><br>
1. From <code>Approver_workflow.html</code>, Approver can either click on the table rows or the document icon in the "check sequence" column
2. From <code>Approver_workflow_sequences.html</code>, click on "ASSIGN NEW FORMS" button, a pop up will be shown on the screen
3. Select on the forms, and click "Submit" button. The forms will then be added to the workflow.
<img width="500" alt="Screenshot 2023-03-27 at 5 48 36 PM" src="https://user-images.githubusercontent.com/85498185/227906573-26758f46-b935-496e-8d4c-4deb970d1d7b.png">

#### Delete Forms from Workflow
<ins>Steps to Delete Form from Workflow</ins><br>
1. From <code>Approver_workflow.html</code>, Approver can either click on the table rows or the document icon in the "check sequence" column
2. At <code>Approver_workflow_sequences.html</code>, click on the icon in the "Delete" column. 
3. After clicking, it will delete the form from workflow.

#### View Form
<ins>Steps to View Form</ins><br>
1. From <code>Approver_workflow.html</code>, Approver can either click on the table rows or the document icon in the "check sequence" column
2. At <code>Approver_workflow_sequences.html</code>, click on the any table rows. 
3. It will lead to <code>Approver_form_sequences2.html</code>, where it will show all the questions and answers from the fomr
4. Approver CANNOT submit or edit form. If Approver would like to do so, they have to go to [click on this link](#approver-submit-forms)

#### Export Form
<ins>Steps to Export Form</ins><br>
1. From <code>Approver_workflow.html</code>, Approver can either click on the table rows or the document icon in the "check sequence" column
2. At <code>Approver_workflow_sequences.html</code>, click on the any table rows. 
3. At <code>Approver_form_sequences2.html</code>, click on "EXPORT" button
4. The form PDF will be automatically downloaded to the desktop
<img width="500" alt="Screenshot 2023-03-27 at 4 07 33 PM" src="https://user-images.githubusercontent.com/85498185/227880137-d8ac5024-c366-4836-ab93-221fee2512e7.png">

### Accounts Tab
<code>Approver_accounts.html</code>
* This is the Approver's view of the accounts page
* It displays all the accounts of all 3 types (Admin, Approver & Vendor) registered in the system.
* An Approver can create an account of any 1 of the 3 types by clicking either "CREATE VENDOR ACCOUNT", "CREATE APPROVER ACCOUNT" or "CREATE ADMIN ACCOUNT".
* An Approver can delete any existing accounts by clicking the delete button that is represented by a trash can icon.
* An Approver can update any existing accounts by clicking the update button that is represented by a document & pen icon. <br>
<img width="500" alt="approver accounts page" src="https://user-images.githubusercontent.com/89073137/227721315-9edcf2d7-d687-4173-b3c3-d0ca6562cff2.PNG">

#### Creating an Account
<ins>Steps to create a vendor account<ins> <br>
<ins>For creating Admin & Approver accounts, click the appropriate "CREATE _____ ACCOUNT" under step 1 and follow the rest of the steps. <ins> <br>
1. At <code>Approver_accounts.html</code>, Approver can click on "CREATE VENDOR ACCOUNT" located at the bottom right corner. <br>
2. After clicking, a modal will appear that will allow the Approver to enter the necessary details to create the account. <br>
3. After filling in the information, the Approver can click on the blue Save button that's located at the bottom of the modal. <br>
4. If no fields are left empty and all fields are valid, the account is now successfully created. 
<img width="500" alt="create vendor account approver" src="https://user-images.githubusercontent.com/89073137/227721392-5bad9965-3f55-43f8-b13e-ae31abcf8c79.PNG"><br>

#### Updating an Account
<ins>Steps to update an account<ins> <br>
<ins>Example given is for updating Vendor account, but the steps apply to all 3 types of accounts<ins> <br>
1. At <code>Approver_accounts.html</code>, under a particular account, Approver can click on the update button (represented by a document & pen icon) associated to the account to update account information. <br>
2. After clicking, a modal will appear that will allow the Approver to edit the necessary details to update the account. <br>
3. After filling in the information, the Approver can click on the blue Save button that's located at the bottom of the modal. <br>
4. If no fields are left empty and all fields are valid, the account is now successfully updated. 
<img width="500" alt="update account approver" src="https://user-images.githubusercontent.com/89073137/227721449-9b02b12e-2299-423d-87a2-5c044e124d77.PNG"><br>

### Forms Tab
<code>Approver_form.html</code><br>
* This page shows all the forms that exists 
* Approver can either view , edit or delete form <br>
<img width="500" alt="Screenshot 2023-03-27 at 5 52 14 PM" src="https://user-images.githubusercontent.com/85498185/227907568-41aa6e60-f2da-4f59-b163-65f7fb812d79.png">


#### Delete Form
<ins>Steps to Delete Form<ins><br>
1. At <code>Approver_form.html</code>, click on the icon in "DELETE" column to delete form
2. After clicking, the form will be removed from the table

#### View Question Details
<ins>Steps to View Question Details<ins><br>
1. At <code>Approver_form.html</code>, either click on the icon in "FORM DOCUMENT" column or any table rows
2. It will lead to <code>Approver_Individual_form.html</code>, where all the questions details (Eg: Field Type, Field Name) will be shown

#### Create New Form
<ins>Steps to Create New Form<ins><br>
1. At <code>Approver_form.html</code>, click on "CREATE NEW FORM" button. A pop up will be shown on the screen
2. Fill in the Form Name field and click on the "Submit" button
3. Form will be created and added to the table 
<img width="500" alt="Screenshot 2023-03-27 at 5 53 05 PM" src="https://user-images.githubusercontent.com/85498185/227907793-89a68253-8985-4cbf-9c8e-341e99903344.png">

#### Edit Form Name
<ins>Steps to Edit Form Name<ins><br>
1. At <code>Approver_form.html</code>, either click on the icon in "FORM DOCUMENT" column or any table rows
2. It will lead to <code>Approver_individual_form.html</code>, where all the questions details (Eg: Field Type, Field Name) will be shown
3. Click on the Input beside Form Name, and fill in the new form name. It will edit the form name accordinly
<img width="500" alt="Screenshot 2023-03-27 at 4 49 28 PM" src="https://user-images.githubusercontent.com/85498185/227891252-1a8adf22-6962-448c-9351-aaf5402e2800.png">

#### Edit Section Title, ID, Description
<ins>Steps to Edit Section Title, ID, Description<ins><br>
1. At <code>Approver_form.html</code>, either click on the icon in "FORM DOCUMENT" column or any table rows
2. It will lead to <code>Approver_individual_form.html</code>, where all the questions details (Eg: Field Type, Field Name) will be shown
3. At <code>Approver_Individual_form.html</code>,
    * **Section Title**: Click on the Input from "SECTION TITLE" column and edit accordingly
    * **Section Description**: Click on the Input from "SECTION DESCRIPTION" column and edit accordingly
    * **Section ID**: Click on the dropdown and select the section Ids from "SECTION ID" column
<img width="500" alt="Screenshot 2023-03-27 at 4 48 24 PM" src="https://user-images.githubusercontent.com/85498185/227891052-79895b3d-e287-4dc4-b700-c5dcf861cb77.png">

#### Edit Field Name, Field Type, Input Options, Required
<ins>Steps to Edit Field Name, Field Type, Input Options, Required<ins><br>
1. At <code>Approver_form.html</code>, either click on the icon in "FORM DOCUMENT" column or any table rows
2. It will lead to <code>Approver_individual_form.html</code>, where all the questions details (Eg: Field Type, Field Name) will be shown
3. At <code>Approver_Individual_form.html</code>,
  * **Field Name**: Click on the Input from "FIELD NAME" column and edit accordingly
  * **Field Type**: Click on the dropdown and select the field types 
  * **Required**: Click on the dropdown and select the option (True: it is required; False: It is not required)
  * **Input Options**:
      * "Edit Options" will only appear if the field types are either <ins>Radio<ins> or <ins>Checkbox<ins>
      * To Edit the Options:
        1. Click on the "Edit Options"; A pop up will be shown on the screen
        2. Select the Number of Input Options
        3. Click on the "->"
        4. The options input will be shown; fill it in and click submit
        5. The new options will be shown in the "INPUT OPTIONS" column
        5. **Error Handling**: 
            * Scenario 1: Input cannot be empty
            * Scenario 2: Input cannot be the same 
        6. (EXTRA) if "others" is added into the Input Options, it will automatically create a "(Others) ____[Field Name]___ " question and added to the section that belongs to that question.
<img width="500" alt="Screenshot 2023-03-27 at 4 52 19 PM" src="https://user-images.githubusercontent.com/85498185/227892044-e0620f7b-08d2-48f4-96cc-a497957170b0.png">

#### Delete Field
<ins>Steps to Delete Field<ins><br>
1. At <code>Approver_form.html</code>, either click on the icon in "FORM DOCUMENT" column or any table rows
2. It will lead to <code>Approver_Individual_form.html</code>, where all the questions details (Eg: Field Type, Field Name) will be shown
3. At <code>Approver_Individual_form.html</code>, click on the icon in "DELETE" column to delete the field.

#### Create New Field/Question 
<ins>Steps to Create New Field/Question<ins><br>
1. At <code>Approver_form.html</code>, either click on the icon in "FORM DOCUMENT" column or any table rows
2. It will lead to <code>Approver_Individual_form.html</code>, where all the questions details (Eg: Field Type, Field Name) will be shown
3. At <code>Approver_Individual_form.html</code>, click on "CREATE NEW FIELDS" button. A pop up will be shown
4. Approver can either add the new field to a existing section or to a new section.
    * If Approver wants to add new field to the new section, click on "Add New Sections" button. A New Section ID will automatically be assigned, and the Section Title and Description will be shown for Admin to fill in
    <img width="500" alt="Screenshot 2023-03-27 at 5 06 10 PM" src="https://user-images.githubusercontent.com/85498185/227895611-05ffb825-e388-4829-8559-345a6d548129.png"> <br>
    * If Approver wants to add new field to an existing section, click on "Add Existing Sections"
    <img width="500" alt="Screenshot 2023-03-27 at 5 07 13 PM" src="https://user-images.githubusercontent.com/85498185/227895896-d53d475f-c42c-4394-a6ed-5523e171727a.png"> <br>
    * However, if there is no existing sections, the "Add to Existing Sections" button will be disabled.
5. **Error Handling**: 
    * Scenario 1: Input cannot be empty
    * Scenario 2: Input cannot be the same 
6. (EXTRA) if "others" is added as an Input Options, it will automatically create a "(Others) ____[Field Name]___ " question and added to the section that belongs to that question.

#### View Form Format
<ins>Steps to View Form Format<ins><br>
1. At <code>Approver_form.html</code>, either click on the icon in "FORM DOCUMENT" column or any table rows
2. It will lead to <code>Approver_Individual_form.html</code>, where all the questions details (Eg: Field Type, Field Name) will be shown
3. At <code>Approver_Individual_form.html</code>, click on "VIEW FORM" button
4. It will lead to <code>Approver_overview_form.html</code>, where Approver can get an overview of how the form will look like
<img width="500" alt="Screenshot 2023-03-27 at 5 10 38 PM" src="https://user-images.githubusercontent.com/85498185/227896652-bcec39b7-51ef-41e0-9a24-b646bc09a9f2.png">

#### (EXTRA) Adjust Table Column Size
<ins>Steps to Adjust Table Column Size<ins><br>
1. At <code>Approver_Individual_form.html</code>, click and drag the lines in between the columns (applicable for table header and row 1 only)
2. Once it is dragged, the table column will change its size accordingly
<img width="500" alt="Screenshot 2023-03-27 at 6 10 38 PM" src="https://user-images.githubusercontent.com/85498185/227912594-1b4ba8eb-5f42-48a9-9a23-4422c46dadca.png">
