create table cscl_age_filter (
	id_ LONG not null primary key,
	name VARCHAR(75) null,
	value VARCHAR(75) null,
	isActive BOOLEAN
);

create table cscl_locality_master (
	localityId LONG not null primary key,
	name VARCHAR(75) null,
	isActive BOOLEAN
);

create table cscl_polls_choice (
	choiceId LONG not null primary key,
	questionId LONG,
	name VARCHAR(75) null,
	description STRING null,
	lastPublishDate DATE null
);

create table cscl_polls_master (
	entryId LONG not null primary key,
	voteId LONG,
	questionId LONG,
	choiceId LONG,
	name VARCHAR(75) null,
	email VARCHAR(75) null,
	mobile VARCHAR(10) null,
	birthDate DATE null,
	sex VARCHAR(75) null,
	locality INTEGER,
	createdDate DATE null,
	modifiedDate DATE null
);

create table cscl_polls_question (
	questionId LONG not null primary key,
	title STRING null,
	question STRING null,
	description STRING null,
	expirationDate DATE null,
	lastPublishDate DATE null,
	lastVoteDate DATE null
);