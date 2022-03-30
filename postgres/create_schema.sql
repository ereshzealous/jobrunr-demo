START TRANSACTION;

CREATE EXTENSION if not exists "uuid-ossp";

CREATE TABLE customer (
                          id  TEXT PRIMARY KEY DEFAULT uuid_generate_v4(),
                          first_name text not null,
                          last_name text,
                          email TEXT NOT NULL UNIQUE,
                          mobile_number TEXT NOT NULL,
                          created_on TIMESTAMP DEFAULT now()
);

commit;