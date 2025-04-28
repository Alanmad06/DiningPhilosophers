|This project offers a Java-based simulation of the classic Dining Philosophers Problem, a fundamental example in concurrent programming that illustrates synchronization challenges, 
resource sharing, and deadlock avoidance.​


🧠 Problem Overview
The Dining Philosophers Problem involves five philosophers seated around a circular table, each alternating between thinking and eating.
To eat, a philosopher requires two forks—one on their left and one on their right. However, with only five forks available, this setup can lead to issues such as:​

Deadlock: A situation where each philosopher holds one fork and waits indefinitely for the other, preventing any from eating.

Starvation: A scenario where a philosopher never gets both forks due to others continuously taking them.

Livelock: A condition where philosophers continuously change states without making progress.​

This simulation demonstrates how proper synchronization techniques can prevent these issues, ensuring that all philosophers can eat without conflicts.​


⚙️ Implementation Details
Language: Java

Concurrency: Utilizes Java's multithreading capabilities to simulate each philosopher as an independent thread.

Synchronization: Employs mechanisms such as semaphores or monitors to manage access to shared resources (forks), preventing deadlocks and ensuring mutual exclusion.

IDE Support: Includes NetBeans project configuration (nbproject/) for easy setup and execution.|
![image](https://github.com/user-attachments/assets/25d6320b-d3ed-448f-b92f-35bb33a0ab6e)
![image](https://github.com/user-attachments/assets/0f564cef-f63b-4ec0-807a-7d146a674a32)
