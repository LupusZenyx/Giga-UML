import sqlite3
import sys

def connect_db():
    conn = sqlite3.connect('users.db')
    with conn:
        conn.execute('''
            CREATE TABLE IF NOT EXISTS users (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                username TEXT NOT NULL UNIQUE,
                password TEXT NOT NULL
            )
        ''')
    return conn

def add_user(conn, username, password):
    with conn:
        conn.execute('INSERT INTO users (username, password) VALUES (?, ?)', (username, password))

def remove_user(conn, username):
    with conn:
        conn.execute('DELETE FROM users WHERE username = ?', (username,))

def main():
    if len(sys.argv) < 2:
        print("Usage: python manage_users.py [add|remove] [username] [password]")
        return

    action = sys.argv[1]
    conn = connect_db()

    if action == 'add':
        if len(sys.argv) != 4:
            print("Usage: python manage_users.py add [username] [password]")
            return
        username = sys.argv[2]
        password = sys.argv[3]
        add_user(conn, username, password)
        print(f"User {username} added.")
    elif action == 'remove':
        if len(sys.argv) != 3:
            print("Usage: python manage_users.py remove [username]")
            return
        username = sys.argv[2]
        remove_user(conn, username)
        print(f"User {username} removed.")
    else:
        print("Unknown action. Use 'add' or 'remove'.")

if __name__ == '__main__':
    main()