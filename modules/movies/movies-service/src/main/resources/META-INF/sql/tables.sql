create table movies_Author (
	uuid_ VARCHAR(75) null,
	authorId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	authorName VARCHAR(75) null,
	biography VARCHAR(75) null,
	movieId LONG
);

create table movies_Movie (
	uuid_ VARCHAR(75) null,
	movieId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	movieName VARCHAR(75) null,
	description VARCHAR(75) null,
	rating INTEGER,
	userName VARCHAR(75) null
);