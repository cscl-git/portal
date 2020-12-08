create table cscl_rti_payment (
	id_ LONG not null primary key,
	applicantName VARCHAR(75) null,
	applicantEmail VARCHAR(75) null,
	applicantMobile VARCHAR(75) null,
	address VARCHAR(75) null,
	rtiSubject VARCHAR(75) null,
	rtiFeeAmount INTEGER,
	createdDate DATE null,
	modifiedDate DATE null,
	refId VARCHAR(75) null
);