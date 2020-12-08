create table cscl_tender (
	uuid_ VARCHAR(75) null,
	tenderId LONG not null primary key,
	createdById LONG,
	updatedById LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title STRING null,
	description TEXT null,
	tenderCategoryId LONG,
	publishDate DATE null,
	lastApplyDate DATE null,
	tenderOpeningDate DATE null,
	status INTEGER
);

create table cscl_tender_category (
	tenderCatId LONG not null primary key,
	createdById LONG,
	createDate DATE null,
	category STRING null
);