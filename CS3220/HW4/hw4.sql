 


create  table Candidates (
id integer auto_increment primary key,
name varchar(255),specialties varchar(800),presentation varchar(800))

insert into Candidates (name,specialties,presentation) values ('John','Machine Learning','10am on 2/20 in ET A227')
insert into Candidates (name,specialties,presentation) values ('Jack','Computer Vision','10am on 2/25 in ET A332')
insert into Candidates (name,specialties,presentation) values ('Jane','Machine Learning','3pm on 2/27 in ET A126')
insert into Candidates (name,specialties,presentation) values ('May','Computer Science Education','3:30pm on 3/11 in FA 219')

create  table feedbacks (
id integer auto_increment primary key,name varchar(255), 
message varchar(800), date timestamp,candidate_id  integer references  candidates(id),
rate integer)

insert into feedbacks (name,message,date,candidate_id,rate)values ('Sue',' I like his research. Seems to be a nice person.',now(),1,5)
insert into feedbacks (name,message,date,candidate_id,rate)values 
('Tom','The presentation was not very well organized. He may be a good researcher but I don t think hell be a good teacher. ',now(),1,3)