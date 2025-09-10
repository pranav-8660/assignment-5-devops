from flask import Flask
import os

app = Flask(__name__)

@app.route("/")
def hello():
    name = os.getenv("APP_NAME", "World")
    api_key = os.getenv("API_KEY", "no-key")
    return f"Hello, {name}! Your API_KEY is {api_key}"

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)
