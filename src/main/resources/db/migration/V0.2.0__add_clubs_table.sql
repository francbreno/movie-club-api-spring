CREATE TABLE IF NOT EXISTS clubs (
	id bigint auto_increment PRIMARY KEY,
	club_id uuid NOT NULL,
	user_id uuid NOT NULL,
	name VARCHAR(255) NOT NULL
);
