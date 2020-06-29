## Instalação do Helm
```
https://helm.sh/docs/intro/install/

// se precisar
helm repo add stable https://kubernetes-charts.storage.googleapis.com/

```

## Instalação do minikube
https://kubernetes.io/docs/tasks/tools/install-minikube/

```
curl -Lo minikube https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64 \
  && chmod +x minikube

sudo mkdir -p /usr/local/bin/
sudo install minikube /usr/local/bin/

```  

## Subir minikube
```

// iniciar padrão
minikube start

// iniciar alocando memoria e processador
minikube start --cpus 4 --memory 8192


```

## Instalar o kubectl
```
sudo snap install kubectl --classic  
```

## Comandos do kubernetes
```
kubectl get pods
kubectl get pods --all-namespaces
```

## Configurando o Docker Registry
```
minikube addons enable registry  
kubectl get pods -n kube-system
kubectl port-forward --namespace kube-system registry-5l9rw 5000:5000
```  

Comandos para compilar a aplicação, gerar a imagem e dar o push do registry
```
// gerar os arquivos
mvn clean package fabric8:build fabric8:push fabric8:resource fabric8:helm

// validar os arquivos gerados
mvn -Ddeployment.replicas=3 validate fabric8:resource fabric8:helm

kubectl create namespace netflix

// instalando

// run netflix-gateway
helm install  netflix target/fabric8/helm/kubernetes/netflix-app  --namespace=netflix

// run netflix-fullhd
helm install  netflixfullhd target/fabric8/helm/kubernetes/netflix-fullhd  --namespace=netflix

// run netflix-fullhd
helm install netflixhd target/fabric8/helm/kubernetes/netflix-hd  --namespace=netflix

// run netflix-pocket
helm install  netflixpocket target/fabric8/helm/kubernetes/netflix-pocket  --namespace=netflix

// Removendo

// run netflix-gateway
helm uninstall  netflix target/fabric8/helm/kubernetes/netflix-app  --namespace=netflix

// run netflix-fullhd
helm uninstall  netflixfullhd target/fabric8/helm/kubernetes/netflix-fullhd  --namespace=netflix

// run netflix-fullhd
helm uninstall netflixhd target/fabric8/helm/kubernetes/netflix-hd  --namespace=netflix

// run netflix-pocket
helm uninstall  netflixpocket target/fabric8/helm/kubernetes/netflix-pocket  --namespace=netflix


```
