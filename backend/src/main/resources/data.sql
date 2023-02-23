DELETE FROM WORK_FLOW;
DELETE FROM USER;

-- insert Vendor rows
insert into user (user_id, user_type, email_address, password, user_name, business_type, company_name, evaluation_id, office_address, office_fax, office_tel, registration_no)
    values (1,"VENDOR", "john.doe@gmail.com", "1234567", "johnDoe", "private", "Apple", "654321", "1 Infinite Loop ", "12345678", "12345678", "2");
insert into user (user_id, user_type, email_address, password, user_name, business_type, company_name, evaluation_id, office_address, office_fax, office_tel, registration_no)
    values (2,"VENDOR", "jane.doe@gmail.com", "1234567", "janeDoe", "private", "Meta", "654321", "1 Hacker Wat ", "12345678", "12345678", "2");
insert into user (user_id, user_type, email_address, password, user_name, business_type, company_name, evaluation_id, office_address, office_fax, office_tel, registration_no)
    values (3,"VENDOR", "jeff.bezos@gmail.com", "1234567", "jeffBezos", "private", "Amazon", "654321", "1 Amazon Street ", "12345678", "12345678", "3");

-- insert admin and approve rows
insert into user (user_id, user_type, email_address, password, user_name, business_type, company_name, evaluation_id, office_address, office_fax, office_tel, registration_no)
    values (4,"ADMIN", "admin1@gmail.com", "1234567", "admin1", null, null, null, null, null, null, null);
insert into user (user_id, user_type, email_address, password, user_name, business_type, company_name, evaluation_id, office_address, office_fax, office_tel, registration_no)
    values (5,"APPROVER", "approver1@gmail.com", "1234567", "approver1", null, null, null, null, null, null, null);
insert into user (user_id, user_type, email_address, password, user_name, business_type, company_name, evaluation_id, office_address, office_fax, office_tel, registration_no)
    values (6,"ADMIN", "admin2@gmail.com", "1234567", "admin2", null, null, null, null, null, null, null);
