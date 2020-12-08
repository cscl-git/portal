create index IX_F99188E8 on cscl_age_filter (isActive);

create index IX_FA02FD62 on cscl_locality_master (isActive);

create index IX_B2D28EB0 on cscl_polls_master (birthDate, locality, questionId);
create index IX_C9E91299 on cscl_polls_master (birthDate, questionId);
create index IX_81B0563E on cscl_polls_master (birthDate, sex[$COLUMN_LENGTH:75$], locality, questionId);
create index IX_962253A7 on cscl_polls_master (birthDate, sex[$COLUMN_LENGTH:75$], questionId);
create index IX_A7BFA345 on cscl_polls_master (locality, questionId);
create index IX_F355ED6E on cscl_polls_master (questionId);
create index IX_B811D6C9 on cscl_polls_master (sex[$COLUMN_LENGTH:75$], locality, questionId);
create index IX_DC25F5F2 on cscl_polls_master (sex[$COLUMN_LENGTH:75$], questionId);