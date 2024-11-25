# GOAL 
- Build REST API using SpringBoot
- Build UI using ReactJS
- Run app Locally using docker-compose
- Deploy app on Kubernetes (kind) Cluster
-------------------------------------------

BACKEND 
- Build REST API using Java 17, Spring Boot 3.3.5, mySQL, maven
- Spring Data JPA
- Flyway DB Migration (H2, MYSQL)
- Integration Testing using testcontainers
- Github actions (CI/CD)
--------------------------------
FRONTEND
- Build UI using ReactJS/NextJS
- Bootstrap CSS
- Axios for API communication
--------------------------------
DOCKER & KUBERNETES
- Dockerizing the application using buildpacks and jib
- Dev environnement using docker-compose
- Kubernetes - Pods, Replicas, Deployment, Service, Ingress
--------------------------------
DEPLOYMENT
- Setting up kubernetes Kind Cluster (Kind directory)
- Deploy app on Kubernetes (Using Yaml Files) 
- Using Lens as K8s GUI
--------------------------------


How to run?

```
$ git clone https://github.com/os2506/spring-boot-k8s.git
$ cd spring-boot-k8s
$ ./run.sh start
$ ./run.sh stop

$ ./run.sh start_infra
$ ./run.sh stop_infra
```
--------------------------------
Running on Kubernetes?

```
$ cd spring-boot-k8s/article-api
$ cd kind
$ ./create-cluster.sh
$ cd ../
$ kubectl apply -f k8s/
```
--------------------------------

- Access API using NodePort http://localhost:18080/api/articles
- Access UI using NodePort http://localhost:30080/
- Access API using Ingress http://localhost/article-api/api/articles
- Access UI using Ingress http://localhost/


Kubernetes Useful commands
--------------------------
```
kubectl get pods
kubectl get all
kubectl run article-api --image=adndev29/myrepo:article-api --restart=Never --port=8080 --labels=env=dev,version=1.0
kubectl get all
kubectl describe pods article-api
kubectl delete pods article-api

kubectl run article-api --image=adndev29/myrepo:article-api --restart=Never --port=8080 --labels=env=dev,version=1.0 --dry-run=client -o yaml > pod.yaml
kubectl apply -f pod.yaml
kubectl logs article-api -f
kubectl exec -it article-api -- /bin/sh
kubectl delete -f pod.yaml

kubectl get ns
kubectl create ns dev
kubectl run article-api --image=adndev29/myrepo:article-api --restart=Never --port=8080 -n dev -o yaml --dry-run=client > pod.yaml

kubectl get pods -n dev
kubectl delete ns dev
```

Deployments
-----------

```
kubectl create deployment article-api-deploy --image=adndev29/myrepo:article-api
kubectl create deployment article-api-deploy --image=adndev29/myrepo:article-api --dry-run=client -o yaml > deployment.yaml
kubectl describe deployments.apps/article-api-deploy
kubectl rollout history deployments article-api-deploy
kubectl scale deployment article-api-deploy --replicas=3

kubectl set image deployment article-api-deploy article-api=adndev29/myrepo:bookmarker-api:1.1
kubectl rollout status deployment article-api-deploy

kubectl rollout undo deployment article-api-deploy --to-revision=1
```

ConfigMaps & Secrets
--------------------

```
kubectl create configmap db-config --from-literal=db_host=mysql --from-literal=db_name=appdb
kubectl create configmap db-config --from-env-file=config.env
kubectl create configmap db-config --from-file=config.txt
kubectl create configmap db-config --from-file=app-config
kubectl describe configmaps db-config
kubectl get configmaps db-config -o yaml

kubectl create secret generic db-creds --from-literal=pwd=s3cret
kubectl create secret generic db-creds --from-env-file=secret.env
kubectl create secret generic ssh-key --from-file=id_rsa=~/.ssh/id_rsa
echo -n 's3cret!' | base64
kubectl get secret db-creds

```

Services
--------
- ClusterIP: Exposes the Service on a cluster-internal IP. Only reachable from within the cluster.
- NodePort: Exposes the Service on each node's IP address at a static port. Accessible from outside of the cluster.
- LoadBalancer: Exposes the Service externally using a cloud provider's load balancer.
- ExternalName: Maps a Service to a DNS name.

```
kubectl expose deployment article-api-deploy --port=8080 --target-port=8080 --type=NodePort
```


  
