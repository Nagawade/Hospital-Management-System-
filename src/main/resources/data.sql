INSERT IGNORE INTO patient (name, birth_date, gender, email, created_at, blood_group)
VALUES
  ('Rohit Bagwale',   '2003-10-26', 'Male',   'rrbagwale@gmail.com', CURRENT_TIMESTAMP, 'O_Positive'),
  ('Tanmay Dalvi',     '2003-12-24', 'Male', 'tanmaydalvi@gmail.com',     CURRENT_TIMESTAMP, 'B_Positive'),
  ('Amit Verma',     '2001-01-10', 'Male',   'amit.verma@example.com',     CURRENT_TIMESTAMP, 'AB_Positive'),
  ('Priya Kulkarni', '1998-12-03', 'Female', 'priya.kulkarni@example.com', CURRENT_TIMESTAMP, 'O_Negative'),
  ('Rohan Mehta',    '2002-07-30', 'Male',   'rohan.mehta@example.com',     CURRENT_TIMESTAMP, 'AB_Negative'),
  ('Mauli Nagawade', '2003-01-11', 'Male',   'maulinagawade5@gmail.com',     CURRENT_TIMESTAMP, 'O_Positive');


INSERT IGNORE INTO doctor (name, specialization, email) VALUES
('Dr. Shravan Chaturvedi', 'Cardiology', 'schaturvedi@gmail.com'),
('Dr. Raam Sharma', 'Dermatology', 'shreeraam123@gmail.com'),
('Dr. Raghunath Ayadhyawala', 'Orthopedics', 'raghunaatgad5@gmail.com');

