INSERT INTO department (id, name) VALUES
    ("CO", "Department of Computer Engineering"),
    ("EM", "Department of Engineering Mathematics"),
    ("EE", "Department of Electrical & Electronic Engineering"),
    ("ME", "Department of Mechanical Engineering"),
    ("CE", "Department of Civil Engineering"),
    ("CP", "Department of Chemical & Process Engineering"),
    ("PR", "Department of Manufacturing & Industrial Engineering");

INSERT INTO course (code, name, credits) VALUES
    ("CO221", "Digital Design", 3),
    ("CO222", "Programming Methodology", 3),
    ("CO223", "Computer Communication Networks I", 3),
    ("EM211", "Ordinary Differential Equations", 2),
    ("EM213", "Probability & Statistics", 2),
    ("EM214", "Discrete Mathematics", 3),
    ("EE282", "Network Analysis for Computer Engineering", 3),
    ("CO224", "Computer Architecture", 3),
    ("CO225", "Software Construction", 3),
    ("CO226", "Database Systems", 3),
    ("EM215", "Numerical Methods", 3),
    ("EM212", "Calculus II", 3),
    ("EE285", "Electronics I", 3);

INSERT INTO user (user_name, password, mail, honorific, initials, last_name, role, contact, dept_id, profile_picture) VALUES
    ("admin", "123", "admin@eng.pdn.ac.lk", "Mr", "A.", "Mihindu", "admin", "0777123456", null, null),
    ("E/19/275", "456", "e19275@eng.pdn.ac.lk", "Mr", "M. S.", "Peeris", "student", "0777199768", "CO", null),
    ("co-Kernighan", "789", "kernighan@eng.pdn.ac.lk", "Mr", "B.", "Kernighan", "lecturer", "0777987654", "CO", null),
    ("co-Torvalds", "bash", "torvalds@eng.pdn.ac.lk", "Mr", "L.", "Torvalds", "lecturer", "0777111111", "CO", null),
    ("em-Woo", "314", "woo@eng.pdn.ac.lk", "Mr", "E.", "Woo", "lecturer", "0777678678", "EM", null);



