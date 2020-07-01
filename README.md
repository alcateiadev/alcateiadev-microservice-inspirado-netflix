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
kubectl port-forward --namespace kube-system registry-wndk5 5000:5000
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

## Configurando o Ingress
Na pasta Docker, rodar o comando
```
kubectl apply -f ingress-netflix.yaml
```

Identificar qual é o IP do minikube
```
minikube ip
```

Adicionar no /etc/hots
```
// comand
sudo nano /etc/hosts

// add linhas no arquivo.  NO LUGAR DO IP ABAIXO, COLOCAR O QUE APARECEU ALI EM CIMA
172.17.0.2      netflix-fullhd.local
172.17.0.2      netflix-hd.local
172.17.0.2      netflix-app.local
172.17.0.2      netflix-pocket.local
```

Executar o comando 
```
minikube ssh
sudo apt-get update
sudo apt-get install nano

sudo nano /etc/hosts

// add linhas no arquivo
172.17.0.2      netflix-fullhd.local
172.17.0.2      netflix-hd.local
172.17.0.2      netflix-app.local
172.17.0.2      netflix-pocket.local

```




## Testando aplicação
```
//Saber o nome do pod
kubectl get pods -n netflix

//Liberando porta
kubectl port-forward --namespace netflix netflix-app-758bc48d5d-rw2lj 8084:8084

// No VLC na opção "Open Network Strem" add os endereços

// http://localhost:8084/fullhd/v1/load
```