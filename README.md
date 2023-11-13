<h1 align="center">
  Microservices
</h1>  

<div align="center">
  The project is a POC, which was used in the distributed systems discipline. It is a system that involves the concept of microservices, here we use concepts of discovery/registration systems to manage IP and port changes in the real world, 
  gateways to redirect requests to different microservices, in addition to 2 microservices with resources, one for authentication and the other another for recording opportunities.
  
</div>

<h1 align="center">Technologies</h1>

<div align="center">
  To manage all these resources, technologies such as Netflix Eureka were used to manage the discovery and registration of microservices, the concept of gateways and spring boot were also used. The entire database is saved in a file using h2, however, nothing prevents you from using postgres to store the data. Furthermore, Feigh Cliente was used for communication between microservices.
  The microservice concept revolves around scalability and availability, each microservice will have its database and we can use different concepts for updating these resources in order to guarantee consistency in this data.
  
</div>

<h1 align="center">How to run?</h1>

<ol align="left">
  <li>First to run the project you need to raise the eureka server</li>
  <li>Secondly, you need to create the 2 microservices, so that they can register with the eureka server</li>
  <li>Third party needs to run the gateway</li>
  <li>You can access the information of registered microservices using the eureka route: http://localhost:8761/</li>
  <li>If everything went well, you can direct your requests to port 9000, where the gateway is located.</li>
</ol>

<h1 align="center">About</h1>

<h2 align="center">Netflix Eureka</h2>

<div align="center">
Netflix Eureka is a vital component within the microservices architecture of Netflix, functioning as a service registry and discovery tool. Microservices, acting as Eureka clients, dynamically register with the Eureka server by sending heartbeats that contain crucial information about their identity and health status. This registration enables seamless communication between microservices, as the Eureka server maintains an up-to-date registry, facilitating efficient service discovery. The client-server architecture, coupled with continuous heartbeat updates, ensures the resilience and flexibility of Netflix's distributed system.

In essence, Netflix Eureka streamlines microservices communication by allowing them to register dynamically with an Eureka server, providing essential metadata for service discovery. The heartbeat mechanism ensures the server's real-time awareness of the microservices' health and availability, contributing to the overall adaptability and robustness of Netflix's microservices architecture.
</div>

<h2 align="center">Gateway</h2>

<div align="center">
  Gateways serve as intermediaries or entry points in a network architecture, facilitating communication between different systems or networks. In the context of microservices or API management, gateways act as a centralized point for managing, securing, and optimizing the flow of data between various services or clients. They often handle tasks such as authentication, authorization, traffic management, and protocol translation, providing a unified interface for external entities to interact with a distributed system. Gateways play a crucial role in simplifying the complexity of interconnected services, enhancing security, and improving overall system performance.
</div>

<h2 align="center">Microservices</h2>

<div align="center">
Microservices is an architectural approach in software development where an application is built as a collection of small, independent, and loosely coupled services. Each microservice is designed to perform a specific business function and can be developed, deployed, and scaled independently. This modular structure allows for flexibility, easier maintenance, and efficient development, as different teams can work on separate microservices without affecting the entire system. Communication between microservices typically occurs through APIs, enabling seamless integration. This approach promotes agility, scalability, and resilience, making it well-suited for complex and evolving applications. However, it also introduces challenges in terms of service discovery, inter-service communication, and data consistency, which are often addressed through tools like service registries, API gateways, and event-driven architectures.
</div>

<h1 align="center">Contributors</h1>
<div align="center">
  <table>
  <tbody>
    <tr>
      <td align="center" valign="top" width="14.28%"><a href="https://www.linkedin.com/in/kawhan-laurindo-de-lima-b61a7a1b4/"><img src="https://avatars.githubusercontent.com/u/69232156?v=4?s=100" width="100px;" alt="Kawhan Laurindo de Lima"/><br /><sub><b>Kawhan Laurindo de Lima</b></sub></a><br /><a href="#code-Kawhan" title="Code">💻</a></td>
    </tr>
  </tbody>
</table>
</div>
