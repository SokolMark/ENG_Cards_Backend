DROP TABLE IF EXISTS Word;
DROP TABLE IF EXISTS Set;

CREATE TABLE word_set (
                          set_id SERIAL PRIMARY KEY,
                          name VARCHAR(100) NOT NULL
);

CREATE TABLE word (
                      word_id SERIAL PRIMARY KEY,
                      eng_word VARCHAR(100) NOT NULL,
                      ua_word VARCHAR(100) NOT NULL,
                      set_id INTEGER NOT NULL,
                      FOREIGN KEY (set_id) REFERENCES word_set(set_id) ON DELETE CASCADE
);