# IS442 TEAM 8 Quantum

## Login Page
<code>login_home.html</code>
- Users can login to their respective accounts with their email and password. There are total 3 user types (Approver, Admin, Vendor).
- This login page will idenitfy which users belongs to which user type, and bring them to their respective homepage.
<img width="500" alt="Screenshot 2022-11-07 at 3 45 34 PM" src="https://user-images.githubusercontent.com/85498185/226831963-780d0e49-0cdd-4c74-bebc-4f1453796850.png">

## Vendor 
### Homepage
<code>Vendor_workflow.html</code>
  - This is the Vendor's homepage
  - It displays all the pending workflows (workflows with status: IN PROGRESS) that requires Vendors to fill in the forms. 
  - Vendors can either click on the table row or the icon in the forms column to go to the respective workflow page
<img width="500" alt="Screenshot 2023-03-22 at 3 39 45 PM" src="https://user-images.githubusercontent.com/85498185/226833043-4b2ede44-e280-4d6b-bcb5-caf39c75f75c.png">

### Select individual workflow
<ins>Steps to select individual workflow<ins> <br>
 1. From <code>Vendor_workflow.html</code>, Vendors can either click on the table row or the icon in the forms column.
 2. After selecting, it will bring the vendors to <code>Vendor_form.html</code> where it will display all the forms that belongs to that particular workflow <br>
<img width="500" alt="Screenshot 2023-03-22 at 3 46 24 PM" src="https://user-images.githubusercontent.com/85498185/226834370-784b628d-95b3-433d-9418-884ad689e994.png">

### Select individual form
<ins>Steps to select individual form<ins> <br>
 1. From <code>Vendor_workflow.html</code>, Vendors can either click on the table row or the icon in the forms column.
 2. After selecting, it will bring the vendors to <code>Vendor_form.html</code> where it will display all the forms that belongs to that particular workflow <br>
 3. From <code>Vendor_form.html</code>, select any forms that is displayed. It will lead to the <code>Vendor_form_sequence.html</code> where all the questions from the form will be shownn <br>
<img width="500" alt="Screenshot 2023-03-22 at 3 47 26 PM" src="https://user-images.githubusercontent.com/85498185/226834608-4b6cc42f-169e-47d8-87c3-78b1acebda84.png">
  
## Admin
### Homepage
<code>Admin_home.html</code>
  - This is the Admin's homepage
  - It displays all the pending workflows (workflow with status: IN PROGRESS) that requires the Admins to validate the form after Vendors have submitted the form 
  - Admins can click on the table row to go to the respective pending workflows page <code>Admin_individual_pendingwf.html</code>
<img width="500" alt="Screenshot 2023-03-22 at 3 59 43 PM" src="https://user-images.githubusercontent.com/85498185/226837019-2c93739d-0aa8-440e-bd03-580274e29048.png">

### Select individual pending workflow & Validate the forms
<ins>Steps to select individual workflow<ins> <br>
1. From <code>Admin_home.html</code>, Admins can click on the table row
2. After selecting, it will bring the Admins to <code>Admin_individual_pendingwf.html</code> where it will display all the forms that belong to that pending workflow <br>
<img width="500" alt="Screenshot 2023-03-22 at 4 11 49 PM" src="https://user-images.githubusercontent.com/85498185/226839542-5fa05a22-7d8d-4095-b3f6-83d5ed761da7.png"><br>
  
<ins>Steps to validate form<ins> <br>
1. At <code>Admin_individual_pendingwf.html</code>, Admins can select "APPROVED" or "NOT APPROVED" from the dropdown menu in the Approval column. <br>
<img width="500" alt="Screenshot 2023-03-22 at 4 16 23 PM" src="https://user-images.githubusercontent.com/85498185/226840559-a2719df8-4454-4daf-9cf2-502b81be6db7.png"><br>
2. **Scenario 1:** if Admins selects "APPROVED", the status (Status column) will change from "PENDING" to "VALIDATED"
<img width="500" alt="Screenshot 2023-03-22 at 4 17 37 PM" src="https://user-images.githubusercontent.com/85498185/226840879-a51671a7-17f3-45fa-936a-0f6b6ea5bad8.png"> <br>
3. **Scenario 2:** if Admins selects "NOT APPROVED", the status (Status column) will change from "PENDING" to "REQUESTED"
<img width="500" style ="margin-left = 10px" alt="Screenshot 2023-03-22 at 4 15 14 PM" src="https://user-images.githubusercontent.com/85498185/226840328-b8fe5b11-1f30-4b35-b2d1-d2152cf4682c.png"> <br>


  
  
## Approver
