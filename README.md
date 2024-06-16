## Введение

Этот документ содержит инструкции по развертыванию и запуску микросервиса, использующего MongoDB как сервер базы данных. Для управления развертыванием в Kubernetes используется Skaffold, который автоматизирует процесс сборки и развертывания контейнеров.

## Предварительные требования

Прежде чем приступить к развертыванию микросервиса, убедитесь, что на вашем компьютере установлены следующие инструменты:

1. **Minikube** - Инструмент для запуска Kubernetes локально.
2. **Skaffold** - Инструмент для автоматизации разработки для Kubernetes.
3. **kubectl** - Командный интерфейс командной строки для Kubernetes.


### Установка Minikube

Minikube позволяет запускать Kubernetes на локальной машине. Для установки Minikube выполните следующие шаги:

- Скачайте и установите Minikube с [официального сайта](https://minikube.sigs.k8s.io/docs/start/).

### Установка Skaffold

Skaffold облегчает разработку приложений для Kubernetes, автоматизируя процесс сборки и развертывания. Установите Skaffold следующим образом:

- Установите Skaffold, следуя инструкциям на [официальном сайте](https://skaffold.dev/docs/install/).

### Установка kubectl

kubectl является инструментом командной строки для управления кластерами Kubernetes. Установите его, следуя инструкциям на [официальном сайте Kubernetes](https://kubernetes.io/docs/tasks/tools/).


## Запуск микросервиса

### Запуск Minikube

Перед началом работы необходимо запустить Minikube:

minikube start


### Развертывание приложения с помощью Skaffold

В корне проекта должен находиться файл skaffold.yaml, который содержит конфигурацию для сборки и развертывания приложения и MongoDB в Kubernetes. Для запуска приложения выполните следующую команду:

skaffold run


Эта команда автоматически соберет образы Docker, определенные в вашем проекте, и развернет их в Kubernetes с использованием манифестов, указанных в skaffold.yaml.

### Проверка статуса развертывания

Чтобы проверить статус развертывания, используйте команду:

kubectl get pods


Это покажет все поды Kubernetes, созданные в текущем кластере.

## Обращение к сервису

После успешного развертывания вы можете обратиться к вашему микросервису через порт, который был проброшен на ваш локальный компьютер. Используйте команду minikube service <service-name> для получения URL сервиса.

## Заключение

Теперь вы должны иметь работающий микросервис управляемый через Kubernetes с помощью Skaffold. Эти инструкции помогут вам начать работу с локальной разработкой и тестированием вашего микросервиса.