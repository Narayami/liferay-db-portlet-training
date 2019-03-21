create index IX_90A0B754 on movies_Author (authorId, movieId);
create index IX_DFFDAC57 on movies_Author (authorName[$COLUMN_LENGTH:75$]);
create index IX_B0F5FF1D on movies_Author (groupId);
create index IX_C1C96348 on movies_Author (movieId, authorId);
create index IX_840308E1 on movies_Author (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_46CA53A3 on movies_Author (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_55634ECB on movies_Movie (groupId, movieId);
create index IX_1543EEF6 on movies_Movie (groupId, status);
create index IX_138BCB1 on movies_Movie (movieName[$COLUMN_LENGTH:75$]);
create index IX_F5B111AB on movies_Movie (rating);
create index IX_2ADAEEC0 on movies_Movie (status);
create index IX_3108A94E on movies_Movie (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_B7A72B50 on movies_Movie (uuid_[$COLUMN_LENGTH:75$], groupId);