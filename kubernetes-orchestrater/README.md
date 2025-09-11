### I have containerized a flask app. This app reads two environment variables APP_NAME and API_KEY. I have injected these environment variables in the gollowing manner:
- APP_NAME : using configmap 
- API_KEY : using secrets , encoded "super-api-key" using opaque(base64)

### API-Resources used in the application:
- ConfigMap: For injecting the environment variable, APP_NAME
- Secret: For injecting the encrypted environment variable, API_KEY
- Deployment: For setting up the state of the application, adding the docker image of the application and including the secret and configmap key references
- Service : For exposing the application using a network of type NodePort.
