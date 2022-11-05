
insert into users (user_id, username, password) values (1, 'rahul', '$2a$10$OtuDwYtrJtnAHBvE8qmSDu8cPOP7ulv39eoCdztsGY5ykDNWNWZGe');
insert into users (user_id, username, password) values (2, 'neha', '$2a$10$PJm69R7waM9udHFuajfHhOtcg7exPLc.FCNkCMQx0M3WO8.3JNDNC');

insert into roles (role_id, name) values (1, 'USER');
insert into roles (role_id, name) values (2, 'ADMIN');

insert into users_roles (role_id, user_id) values (1, 1), (1, 2), (2, 2);

insert into student (id, First_Name, Last_Name, course, country) values(1, 'Suresh', 'Reddy', 'B.Tech', 'India');
insert into student (id, First_Name, Last_Name, course, country) values(2, 'Mayur', 'Shimar', 'B.Sc', 'Canada');
insert into student (id, First_Name, Last_Name, course, country) values(3, 'LeAnne', 'Schindler', 'BE', 'USA');
insert into student (id, First_Name, Last_Name, course, country) values(4, 'Jane', 'Tarzan', 'B.Arch', 'SA');
insert into student (id, First_Name, Last_Name, course, country) values(5, 'Swroop', 'Pindl', 'M.Sc', 'Australia');
