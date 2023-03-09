DELETE FROM USER;
-- DELETE FROM WORK_FLOW;
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

-- insert workflow rows
-- insert into work_flow (work_flow_id, wf_name, wf_last_submit, wf_dateline, is_validated, user_id)
--     values (1, "workflow1", "2020-01-01", "2020-01-01", false, 1);
-- insert into work_flow (work_flow_id, wf_name, wf_last_submit, wf_dateline, is_validated, user_id)
--     values (2, "workflow2", "2020-01-01", "2020-01-01", true, 2);
-- insert into work_flow (work_flow_id, wf_name, wf_last_submit, wf_dateline, is_validated, user_id)
--     values (3, "workflow3", "2020-01-01", "2020-01-01", false, 3);

-- insert form rows
-- insert into form ( form_id, form_name, date_submitted, last_Edited ) values (1, "form1", "2020-01-01", "2020-01-01");

-- insert formsequence rows
-- insert into form_sequence (form_sequence_id, seq_no, form_id, work_flow_id, status)
--     values (1, 1, 1, 1, "PENDING");
-- insert into form_sequence (form_sequence_id, seq_no, form_id, work_flow_id, status)
--     values (2, 1, 1, 2, "REQUESTED");
-- insert into form_sequence (form_sequence_id, seq_no, form_id, work_flow_id, status)
--     values (3, 1, 1, 3, "PENDING");