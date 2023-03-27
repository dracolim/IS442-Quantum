# IS442 TEAM 8 Quantum

## Login Page
<code>login_home.html</code>
* Users can login to their respective accounts with their email and password. There are total 3 user types (Approver, Admin, Vendor).
* This login page will idenitfy which users belongs to which user type, and bring them to their respective homepage. <br>
<img width="500" alt="Screenshot 2023-03-27 at 2 41 29 PM" src="https://user-images.githubusercontent.com/85498185/227860749-a10d9b96-cd32-45f3-be2f-09d655c5e450.png">

## Vendor 
### Homepage
<code>Vendor_workflow.html</code>
* This is the Vendor's homepage
* It displays all the pending workflows (workflows with status: IN PROGRESS) that requires Vendors to fill in the forms. 
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
 3. From <code>Vendor_form.html</code>, select any forms that is displayed. It will lead to the <code>Vendor_form_sequence.html</code> where all the questions from the form will be shownn <br>
<img width="500" alt="Screenshot 2023-03-27 at 2 57 19 PM" src="https://user-images.githubusercontent.com/85498185/227863829-a4dfc614-5c81-42c3-a13c-2b1159c6d747.png">
  
## Admin
### Homepage (Pending Workflows Page)
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
1. At <code>Admin_individual_pendingwf.html</code>, Admins can select "APPROVED" or "NOT APPROVED" from the dropdown menu in the Approval column. <br>
<img width="500" alt="Screenshot 2023-03-22 at 4 16 23 PM" src="https://user-images.githubusercontent.com/85498185/226840559-a2719df8-4454-4daf-9cf2-502b81be6db7.png"><br>
2. **Scenario 1:** if Admins selects "APPROVED", the status (Status column) will change from "PENDING" to "VALIDATED" <br>
<img width="500" alt="Screenshot 2023-03-22 at 4 17 37 PM" src="https://user-images.githubusercontent.com/85498185/226840879-a51671a7-17f3-45fa-936a-0f6b6ea5bad8.png"> <br>
3. **Scenario 2:** if Admins selects "NOT APPROVED", the status (Status column) will change from "PENDING" to "REQUESTED" <br>
<img width="500" style ="margin-left = 10px" alt="Screenshot 2023-03-22 at 4 15 14 PM" src="https://user-images.githubusercontent.com/85498185/226840328-b8fe5b11-1f30-4b35-b2d1-d2152cf4682c.png"> <br>

#### Submit Forms
<ins>Steps to submit form<ins> <br>
1. At <code>Admin_individual_pendingwf.html</code>, Admin can click on the table row to select the forms they want to view or submit
2. After selecting, it will bring the Admins to <code>Admin_form_sequence.html</code> where it will display all the questions from that form
3. Admin can now check the form as well as fill in the required questions (eg: Admin Evaluation) and submit form. <br>
<img width="500" alt="Screenshot 2023-03-27 at 3 14 51 PM" src="https://user-images.githubusercontent.com/85498185/227867641-6b40c7d9-0b21-4afa-beab-8fa5d82dd7d9.png">

### Workflows Page
<code>Admin_workflow.html</code>
* This is the Admin's overview of all the existed workflows 
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
3. At <code>Admin_workflow_sequences.html</code>, Admin can also 
    * click on the table row to see the form with all the questions and input values 
    * Delete form 
<img width="500" alt="Screenshot 2023-03-27 at 3 32 52 PM" src="https://user-images.githubusercontent.com/85498185/227871805-731e95a4-2b6d-4073-b35f-de8a55b327cc.png">

#### Edit Workflow 


#### Delete Workflow




### Accounts Page
<code>Admin_accounts.html</code>
* This is the Admin's view of the accounts page
* It displays all the accounts of all 3 types (Admin, Approver & Vendor) registered in the system.
* An Admin can create an account of any 1 of the 3 types by clicking either "CREATE VENDOR ACCOUNT", "CREATE APPROVER ACCOUNT" or "CREATE ADMIN ACCOUNT".
* An Admin can delete any existing accounts by clicking the delete button that is represented by a trash can icon.
*  An Admin can update any existing accounts by clicking the update button that is represented by a document & pen icon. <br>
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
  

## Approver
### Accounts Page
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