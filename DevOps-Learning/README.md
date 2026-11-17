# Comprehensive DevOps Laboratory Experiments & Technical Interview Guide

> **Institution Reference:** Department of Computer Science & Engineering, Rajarambapu Institute of Technology  
> **Course:** DevOps (CO1 - CO5)  
> **Target Audience:** DevOps Beginners, Computer Engineering Students, Junior DevOps Engineers, Technical Interview Aspirants  
> **Primary Platform:** macOS (Apple Silicon / Intel) with cross-platform Linux & Windows notes

---

## Table of Contents

1. [Experiment 1: Introduction to DevOps – Understanding Culture, Principles, and Benefits](#experiment-1-introduction-to-devops--understanding-culture-principles-and-benefits)
2. [Experiment 2: Getting Started with Git and Version Control](#experiment-2-getting-started-with-git-and-version-control)
3. [Experiment 3: Collaborating on Projects using GitHub and Pull Requests](#experiment-3-collaborating-on-projects-using-github-and-pull-requests)
4. [Experiment 4: Implementing GitFlow Workflow in a Team-Based Scenario](#experiment-4-implementing-gitflow-workflow-in-a-team-based-scenario)
5. [Experiment 5: Automating Builds and Jobs using Jenkins](#experiment-5-automating-builds-and-jobs-using-jenkins)
6. [Experiment 6: Applying CI/CD Principles to Web Development using Jenkins](#experiment-6-applying-cicd-principles-to-web-development-using-jenkins)
7. [Experiment 7: Introduction to Containerization and Application Deployment using Docker](#experiment-7-introduction-to-containerization-and-application-deployment-using-docker)
8. [Experiment 8: Building a CI/CD Pipeline using Docker and Jenkins](#experiment-8-building-a-cicd-pipeline-using-docker-and-jenkins)
9. [Experiment 9: Demonstrating Maven Build Lifecycle for Java Applications](#experiment-9-demonstrating-maven-build-lifecycle-for-java-applications)
10. [Experiment 10: Implementing Container Orchestration and Deployment using Kubernetes](#experiment-10-implementing-container-orchestration-and-deployment-using-kubernetes)
11. [Master DevOps Tools Summary](#master-devops-tools-summary)
12. [DevOps Command Reference Cheat Sheet](#devops-command-reference-cheat-sheet)
13. [Core Architectural Differences Matrix](#core-architectural-differences-matrix)
14. [Frequently Asked Technical Interview Questions](#frequently-asked-technical-interview-questions)
15. [Recommended Revision Roadmap](#recommended-revision-roadmap)

---

# Experiment 1: Introduction to DevOps – Understanding Culture, Principles, and Benefits

## 1. Experiment Overview
* **Experiment Number:** 01
* **Title:** Introduction to DevOps: Understanding the Culture, Principles, and Benefits
* **Course Outcome:** CO1 – Understand fundamental concepts, culture, and life cycle of DevOps.
* **Aim:** To understand the philosophy, cultural mindset, foundational principles, lifecycle stages, and measurable business benefits of DevOps in modern software engineering.
* **Objectives:**
  1. To identify the breakdown in traditional Waterfall and siloed software delivery models ("The Wall of Confusion").
  2. To master the **CALMS framework** (Culture, Automation, Lean, Measurement, Sharing).
  3. To understand Gene Kim's **The Three Ways** of DevOps.
  4. To explore the 8 phases of the continuous DevOps lifecycle.
  5. To set up and verify a developer workstation for DevOps tools on macOS.
* **Tools and Technologies Required:** Terminal (Zsh), Homebrew package manager, Git, Docker Desktop, VS Code, JDK 17+, Maven 3.9+, Jenkins, Kubectl.
* **Prerequisites:** Basic knowledge of operating system navigation and elementary software development concepts.

## 2. Concepts & Theoretical Background

### 2.1 What is DevOps?
DevOps is not merely a tool, a programming language, or a job title; it is a **cultural movement and operational philosophy** that unifies Software Development (**Dev**) and IT Operations (**Ops**).

```
   +-------------------------------------------------------------+
   |                    TRADITIONAL SILO MODEL                   |
   |                                                             |
   |   [ Developers ]      --- Wall of Confusion ---    [ Operations ] |
   |   Goal: Fast Change                          Goal: Stability     |
   |   "It works on my machine!"                  "It broke production!"
   +-------------------------------------------------------------+
                                   |
                                   v
   +-------------------------------------------------------------+
   |                        DEVOPS MODEL                         |
   |                                                             |
   |       SHARED RESPONSIBILITY, AUTOMATION & COLLABORATION     |
   |                 "You build it, you run it!"                 |
   +-------------------------------------------------------------+
```

### 2.2 The CALMS Framework
Coined by Damon Edwards and John Willis, CALMS defines the 5 pillars of DevOps maturity:
1. **Culture:** Fostering shared responsibility, psychological safety, blameless post-mortems, and breaking organizational silos.
2. **Automation:** Automating repetitive, error-prone tasks (build, test, provision, deploy) to eliminate human error and accelerate feedback.
3. **Lean:** Applying lean manufacturing principles: minimizing Work in Progress (WIP), eliminating waste, and optimizing value streams.
4. **Measurement:** Instrumenting systems to track technical and business metrics (deployment frequency, lead time, MTTR, change failure rate).
5. **Sharing:** Open communication, cross-functional knowledge transfer, and sharing successes, failures, and best practices across teams.

### 2.3 The Three Ways (The Phoenix Project)
* **The First Way (Flow / Systems Thinking):** Accelerate the flow of work from left to right (from Development to Operations to Customer). Never pass a known defect downstream.
* **The Second Way (Amplify Feedback Loops):** Enable fast and continuous feedback from right to left (from Customer/Operations back to Developers) so issues are detected and resolved immediately.
* **The Third Way (Continual Learning & Experimentation):** Cultivate a generative culture of experimentation, calculated risk-taking, practice (e.g., chaos engineering, game days), and institutional learning.

### 2.4 The Continuous DevOps Lifecycle (The Infinity Loop)
The continuous DevOps loop is organized into 8 interconnected phases:
1. **Plan:** Requirements gathering, backlog grooming, issue tracking (Jira, GitHub Issues).
2. **Code:** Writing source code, local testing, version control (Git, GitHub, GitLab).
3. **Build:** Compiling code, packaging dependencies into deployable artifacts (Maven, Gradle, npm).
4. **Test:** Automated unit, integration, and security testing (JUnit, Selenium, SonarQube).
5. **Release:** Versioning, tagging, and approving artifacts ready for deployment.
6. **Deploy:** Infrastructure provisioning, container deployment to target environments (Docker, Kubernetes, Ansible, Terraform).
7. **Operate:** Running applications, managing configurations, handling traffic load balancing.
8. **Monitor:** Real-time log aggregation, metrics collection, and alerting (Prometheus, Grafana, ELK Stack).

---

## 3. Complete Implementation: Setting Up a DevOps Workstation on macOS

### Directory Context
Before running commands, open your macOS Terminal. You will start in your user home directory: `~`.

### Step 1: Install or Update Homebrew (The macOS Package Manager)
Homebrew is the standard package manager for macOS, used to install compilers, command-line tools, and runtime environments.

```bash
# Check if Homebrew is installed; if not, install it
which brew || /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"

# Update Homebrew package definitions
brew update
```
* **Explanation:**
  * `which brew`: Checks if the `brew` binary exists in your `$PATH`.
  * `curl -fsSL ...`: Downloads and executes the official Homebrew installation script.
  * `brew update`: Synchronizes local formula definitions with the latest versions in Homebrew GitHub repositories.
* **Expected Output:**
  ```text
  Already up-to-date.
  ```

### Step 2: Install Core DevOps Toolchain via Homebrew
Execute the following command in terminal:

```bash
brew install git openjdk@17 maven kubectl
```
* **Explanation:**
  * `git`: Distributed version control system.
  * `openjdk@17`: Java Development Kit version 17 Long-Term Support (LTS).
  * `maven`: Build automation and dependency management tool for Java.
  * `kubectl`: Official Kubernetes command-line client to communicate with cluster API servers.

### Step 3: Configure Environment Variables in Shell Profile
On macOS, the default shell is Zsh. Configure `~/.zshrc` so system tools can locate Java and Maven.

```bash
# Append OpenJDK 17 to PATH and set JAVA_HOME in ~/.zshrc
echo 'export PATH="/opt/homebrew/opt/openjdk@17/bin:$PATH"' >> ~/.zshrc
echo 'export JAVA_HOME=$(/usr/libexec/java_home -v 17 2>/dev/null || echo "/opt/homebrew/opt/openjdk@17")' >> ~/.zshrc

# Reload current shell configuration
source ~/.zshrc
```
* **Explanation:**
  * `echo ... >> ~/.zshrc`: Appends export statements to your shell configuration file.
  * `source ~/.zshrc`: Immediately re-reads and applies the configuration to the active terminal session without needing to restart it.

### Step 4: Verify Installation of Core Tools
Execute the verification commands:

```bash
git --version
java -version
mvn -version
kubectl version --client
```
* **Expected Output:**
  ```text
  git version 2.x.x
  openjdk version "17.0.x" ...
  Apache Maven 3.9.x ...
  Client Version: v1.3x.x
  ```

### Step 5: Verify Docker Desktop Engine
Ensure Docker Desktop is installed and running on your Mac. Check its status:

```bash
docker --version
docker info --format '{{.ServerVersion}}'
```
* **Expected Output:**
  ```text
  Docker version 27.x.x (or 29.x.x), build ...
  27.x.x
  ```

---

## 4. Important Commands Reference

| Command | Purpose | Explanation |
| :--- | :--- | :--- |
| `brew install <package>` | Install software packages | Downloads and compiles/installs tools in `/opt/homebrew/` on macOS Apple Silicon. |
| `source ~/.zshrc` | Reload shell environment | Executes the contents of `.zshrc` in current shell context to apply environment variables. |
| `echo $JAVA_HOME` | Inspect Java runtime path | Prints the path pointing to the active JDK directory required by build tools like Maven. |
| `which <tool_name>` | Locate executable path | Searches system `$PATH` directories and prints the full file path of the given command. |
| `docker info` | Inspect Docker daemon status | Displays system-wide information regarding container runtime, storage drivers, and active containers. |

---

## 5. Troubleshooting Common Setup Errors

1. **Error:** `zsh: command not found: brew`
   * **Reason:** Homebrew binary directory (`/opt/homebrew/bin` on Apple Silicon or `/usr/local/bin` on Intel) is missing from the `$PATH` variable.
   * **Solution:** Add `eval "$(/opt/homebrew/bin/brew shellenv)"` to `~/.zprofile` and run `source ~/.zprofile`.
2. **Error:** `The operation couldn't be completed. Unable to locate a Java Runtime.`
   * **Reason:** `JAVA_HOME` is unset or points to an invalid directory.
   * **Solution:** Run `brew --prefix openjdk@17` and set `export JAVA_HOME="/opt/homebrew/opt/openjdk@17"` in `~/.zshrc`.
3. **Error:** `Cannot connect to the Docker daemon at unix:///var/run/docker.sock. Is the docker daemon running?`
   * **Reason:** Docker Desktop application is closed.
   * **Solution:** Open Docker Desktop from macOS Applications (`open -a Docker`) and wait until the whale icon in the status bar turns solid.

---

## 6. Viva and Interview Questions

### Basic Questions (10)
1. **Q: What is DevOps?**  
   *A:* DevOps is a cultural and professional movement that stresses communication, collaboration, and integration between software developers and IT operations professionals to deliver software faster and more reliably.
2. **Q: What problem does DevOps solve in traditional IT?**  
   *A:* It breaks the "Wall of Confusion" where developers wanted frequent changes and operations prioritized system stability, causing blame culture, long release cycles, and buggy deployments.
3. **Q: What does CALMS stand for?**  
   *A:* Culture, Automation, Lean, Measurement, and Sharing.
4. **Q: What are The Three Ways described in DevOps literature?**  
   *A:* The First Way (Fast Flow of work from Dev to Ops), The Second Way (Fast Feedback from Ops to Dev), and The Third Way (Continuous Learning and Experimentation).
5. **Q: What is Continuous Integration (CI)?**  
   *A:* The practice of frequently merging developer code into a central shared repository, followed by automated builds and tests to detect integration bugs early.
6. **Q: What is Continuous Delivery (CD)?**  
   *A:* An automated software release process where code changes are automatically tested and packaged, ready to be deployed to production at any time with a single manual approval.
7. **Q: What is the difference between Continuous Delivery and Continuous Deployment?**  
   *A:* Continuous Delivery requires manual approval to trigger final production deployment; Continuous Deployment deploys every validated build directly to production with zero manual intervention.
8. **Q: What is "Shift Left" in DevOps?**  
   *A:* Moving testing, code quality checks, and security practices earlier into the development lifecycle (to the "left" of the project timeline) rather than testing only before release.
9. **Q: What are the 4 DORA metrics?**  
   *A:* Deployment Frequency, Lead Time for Changes, Mean Time to Recovery (MTTR), and Change Failure Rate.
10. **Q: What is Infrastructure as Code (IaC)?**  
    *A:* The practice of managing and provisioning computing infrastructure through human-readable definition files (like YAML, JSON, or HCL) rather than manual interactive hardware configuration.

### Intermediate Questions (10)
11. **Q: How does DevOps differ from Agile?**  
    *A:* Agile optimizes software development speed and responsiveness to customer requirements (Dev side). DevOps extends Agile principles all the way through delivery, deployment, and operational maintenance (Dev + Ops).
12. **Q: What is the difference between DevOps and SRE (Site Reliability Engineering)?**  
    *A:* DevOps is an abstract philosophy and set of cultural principles; SRE (pioneered by Google) is a concrete implementation of DevOps principles using software engineering techniques to solve operations problems (`class SRE implements DevOps`).
13. **Q: What is Work in Progress (WIP) and why does DevOps minimize it?**  
    *A:* WIP represents unfinished work between stages. High WIP hides bottlenecks, increases context switching, and delays feedback. Lowering WIP speeds up delivery throughput.
14. **Q: What is a Blameless Post-Mortem?**  
    *A:* An incident review process focused on identifying systemic process and technical flaws rather than punishing individuals, encouraging open disclosure of mistakes to prevent recurrence.
15. **Q: What is Technical Debt and how does CI/CD help mitigate it?**  
    *A:* Technical debt is the implied cost of choosing a quick, fragile solution over a robust, maintainable one. CI/CD runs automated static analysis, linters, and tests on every commit, catching design flaws before they accumulate.
16. **Q: What is Dark Launching?**  
    *A:* Deploying a new software feature to production without exposing it to the UI or end-users, testing backend performance, database load, and stability with production-scale data.
17. **Q: What are Feature Toggles (Feature Flags)?**  
    *A:* Configuration switches in code that allow developers to turn features on or off in runtime environments without redeploying code.
18. **Q: What is Mean Time to Recovery (MTTR)?**  
    *A:* The average time required to troubleshoot, fix, and restore a failed system or service back to normal operation.
19. **Q: What is Change Failure Rate (CFR)?**  
    *A:* The percentage of deployments to production that fail, cause service degradation, or require immediate rollback/hotfixes.
20. **Q: What role does Version Control play in DevOps?**  
    *A:* It serves as the single source of truth for application code, configuration files, infrastructure scripts, and automated test suites.

### Practical Scenario-Based Questions (5)
21. **Scenario:** *A development team writes features quickly, but deployments fail frequently on production servers because the servers run different library versions than developer laptops. How does DevOps solve this?*  
    *Answer:* Implement containerization (Docker). Docker bundles application code together with its specific runtime binaries, dependencies, and system configurations into an immutable image. What runs on the developer's laptop runs identically in production.
22. **Scenario:** *A company experiences production downtime every Friday night during deployment releases. How can the team redesign their process using DevOps?*  
    *Answer:* Transition to automated CI/CD pipelines with smaller, frequent commits during regular work hours. Introduce Blue-Green or Rolling deployments so updates occur with zero downtime and instant rollback capabilities.
23. **Scenario:** *A tester reports a critical bug three weeks after a feature was merged. How does CI prevent this delay?*  
    *Answer:* In a CI pipeline, unit, integration, and sanity tests execute automatically within minutes of every push. If a defect is introduced, the build fails immediately ("stop the line"), alerting the developer while the code context is fresh in memory.
24. **Scenario:** *Management wants to adopt DevOps solely by purchasing and installing Jenkins, Docker, and Kubernetes. Will this guarantee success?*  
    *Answer:* No. DevOps is fundamentally cultural. Without collaboration, shared ownership between Dev and Ops, blameless communication, and disciplined testing practices, installing tools will merely automate bad processes faster.
25. **Scenario:** *A high-security financial application requires regulatory audit compliance for all infrastructure changes. How does DevOps fulfill this without manual bottlenecks?*  
    *Answer:* Use GitOps and Infrastructure as Code (IaC). All infrastructure specifications are committed to Git repositories. Every change is approved via Pull Requests with cryptographically signed commits, creating an unalterable audit trail.

---

## 7. Real-World Applications
* **Amazon:** Deploying code changes to production every few seconds across thousands of microservices using automated CI/CD pipelines.
* **Netflix:** Pioneered Chaos Engineering (Chaos Monkey) to randomly terminate production servers, verifying that self-healing systems and microservices recover automatically.
* **Etsy:** Shifted from high-risk bi-monthly batch deployments to deploying 50+ times a day by tearing down silos between designers, developers, and sysadmins.

---

# Experiment 2: Getting Started with Git and Version Control

## 1. Experiment Overview
* **Experiment Number:** 02
* **Title:** Getting Started with Git and Version Control
* **Course Outcome:** CO2 – Apply version control tools and collaborative workflows to software repositories.
* **Aim:** To understand the basics of Git and its role in distributed version control, perform essential repository lifecycle operations (initialization, staging, committing, log tracking), and link a local codebase to GitHub for remote synchronization.
* **Objectives:**
  1. To understand the three logical states of Git: Working Directory, Staging Area (Index), and Git Repository (`.git`).
  2. To create and manage a real project repository containing 5 algorithm-based C programs and documentation.
  3. To track file modifications, stage changes selectively, and commit snapshots with meaningful messages.
  4. To link the local repository with GitHub and push commits to a remote server.
  5. To demonstrate incremental updates by adding a 6th program and pushing new commits.
* **Tools and Technologies Required:** macOS Terminal / Git Bash, Git CLI (v2.x+), Clang / GCC compiler, GitHub Account, VS Code.
* **Prerequisites:** Basic knowledge of file system navigation and C programming fundamentals.

---

## 2. Concepts & Theoretical Background

### 2.1 Centralized vs. Distributed Version Control
* **Centralized VCS (e.g., SVN, CVS):** A single central server stores all versioned files. If the central server crashes or the network disconnects, developers cannot commit, view history, or branch.
* **Distributed VCS (e.g., Git):** Every developer's local machine contains a complete clone of the repository, including the entire history, branches, and tags. Developers can commit, branch, and inspect history completely offline.

```
+---------------------------------------------------------------------------------+
|                               GIT THREE-TREE ARCHITECTURE                        |
|                                                                                 |
|  [ Working Directory ] ------ git add -----> [ Staging Area ] -- git commit -> [ Local Repo (.git) ]
|   (Actual files being                         (Snapshot index                    (Permanent history
|     edited on disk)                             ready to commit)                   SHA-1/SHA-256 blobs)
|          ^                                                                             |
|          |                                                                             |
|          +-------------------------- git checkout / restore --------------------------+
+---------------------------------------------------------------------------------+
                                                                                         |
                                                                                     git push
                                                                                         v
                                                                             [ Remote Repo (GitHub) ]
```

### 2.2 Core Git Concepts
* **Working Directory:** The active folder on your filesystem where you edit code.
* **Staging Area (Index):** An intermediate staging zone where Git records changes that will be included in the next commit. This allows preparing commits selectively rather than bundling all edits blindly.
* **Commit:** An immutable snapshot of the staging area at a point in time, identified by a cryptographic SHA-1 hash (e.g., `4a7b2c9...`). Every commit contains metadata: author, timestamp, parent commit ID, and log message.
* **HEAD:** A special pointer that points to the currently checked-out branch or commit.

---

## 3. Complete Implementation: Managing `C-Programs-Library`

### Directory Context
Open macOS Terminal. Navigate to your desired working folder (e.g., `~/Desktop/devops-lab`):

```bash
mkdir -p ~/Desktop/devops-lab
cd ~/Desktop/devops-lab
```

### Step 1: Configure Git Identity (First-Time Setup)
Set your global name and email address. Git embeds this identity into every commit you author.

```bash
git config --global user.name "Atharv Patil"
git config --global user.email "atharv.patil@example.com"
git config --global init.defaultBranch main

# Verify configuration
git config --list --show-origin
```
* **Explanation:**
  * `git config --global user.name`: Sets the author name for commits on this machine.
  * `git config --global user.email`: Sets the author email linked to your GitHub account.
  * `git config --global init.defaultBranch main`: Ensures new repositories default to `main` instead of the legacy `master`.

### Step 2: Initialize the Repository
Create the project folder specified in the laboratory manual problem statement and initialize Git tracking:

```bash
mkdir C-Programs-Library
cd C-Programs-Library
git init
```
* **Explanation:**
  * `git init`: Creates a hidden `.git` subdirectory containing object stores, refs, HEAD pointer, and config.
* **Expected Output:**
  ```text
  Initialized empty Git repository in /Users/atharv/Desktop/devops-lab/C-Programs-Library/.git/
  ```

### Step 3: Implement the 5 Required C Programs
Create the source code files for the 5 algorithms required by the lab manual.

#### Program 1: Bubble Sort (`bubble_sort.c`)
```bash
cat << 'EOF' > bubble_sort.c
#include <stdio.h>

void bubbleSort(int arr[], int n) {
    int i, j, temp;
    for (i = 0; i < n - 1; i++) {
        for (j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

int main() {
    int arr[] = {64, 34, 25, 12, 22, 11, 90};
    int n = sizeof(arr) / sizeof(arr[0]);
    printf("DevOps Lab - Bubble Sort
Unsorted Array: ");
    for (int i = 0; i < n; i++) printf("%d ", arr[i]);
    bubbleSort(arr, n);
    printf("
Sorted Array:   ");
    for (int i = 0; i < n; i++) printf("%d ", arr[i]);
    printf("
");
    return 0;
}
EOF
```

#### Program 2: Linear Search (`linear_search.c`)
```bash
cat << 'EOF' > linear_search.c
#include <stdio.h>

int linearSearch(int arr[], int n, int key) {
    for (int i = 0; i < n; i++) {
        if (arr[i] == key) return i;
    }
    return -1;
}

int main() {
    int arr[] = {10, 20, 80, 30, 60, 50, 110, 100, 130, 170};
    int n = sizeof(arr) / sizeof(arr[0]);
    int key = 110;
    int index = linearSearch(arr, n, key);
    printf("DevOps Lab - Linear Search
");
    if (index != -1)
        printf("Element %d found at 0-based index %d
", key, index);
    else
        printf("Element %d not found in array
", key);
    return 0;
}
EOF
```

#### Program 3: Factorial using Recursion (`factorial_recursion.c`)
```bash
cat << 'EOF' > factorial_recursion.c
#include <stdio.h>

long long factorial(int n) {
    if (n <= 1) return 1;
    return n * factorial(n - 1);
}

int main() {
    int num = 6;
    printf("DevOps Lab - Factorial via Recursion
");
    printf("Factorial of %d is: %lld
", num, factorial(num));
    return 0;
}
EOF
```

#### Program 4: File I/O Example (`file_io.c`)
```bash
cat << 'EOF' > file_io.c
#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE *fp;
    char buffer[256];

    // Writing to file
    fp = fopen("devops_log.txt", "w");
    if (fp == NULL) {
        perror("Error creating file");
        return 1;
    }
    fprintf(fp, "DevOps Lab Experiment 2: File I/O tracking with Git.
Automated verification test.
");
    fclose(fp);

    // Reading from file
    fp = fopen("devops_log.txt", "r");
    if (fp == NULL) {
        perror("Error reading file");
        return 1;
    }
    printf("DevOps Lab - File I/O Output:
-----------------------------------
");
    while (fgets(buffer, sizeof(buffer), fp) != NULL) {
        printf("%s", buffer);
    }
    fclose(fp);
    return 0;
}
EOF
```

#### Program 5: Matrix Multiplication (`matrix_multiplication.c`)
```bash
cat << 'EOF' > matrix_multiplication.c
#include <stdio.h>

int main() {
    int a[2][2] = {{1, 2}, {3, 4}};
    int b[2][2] = {{5, 6}, {7, 8}};
    int result[2][2] = {{0, 0}, {0, 0}};

    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 2; k++) {
                result[i][j] += a[i][k] * b[k][j];
            }
        }
    }

    printf("DevOps Lab - Matrix Multiplication (2x2 Result):
");
    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 2; j++) {
            printf("%4d", result[i][j]);
        }
        printf("
");
    }
    return 0;
}
EOF
```

### Step 4: Create the Documentation File (`README.md`)
Create a comprehensive markdown file explaining the library:

```bash
cat << 'EOF' > README.md
# C Programs Algorithm Library

## Student Information
* **Student Name:** Atharv Patil
* **Roll Number:** 22UAI001
* **Course:** DevOps Laboratory
* **Academic Year:** 2026-2027

## Repository Description
A centralized, version-controlled repository containing frequently used algorithms and logic-based programs in C, tracked with Git and hosted on GitHub.

## Program Inventory
1. `bubble_sort.c`: Implementation of Bubble Sort comparison algorithm.
2. `linear_search.c`: Sequential search algorithm for array elements.
3. `factorial_recursion.c`: Mathematical factorial using recursive function calls.
4. `file_io.c`: Demonstrates file stream creation, text writing, and reading.
5. `matrix_multiplication.c`: Multiplies two 2x2 integer matrices using nested loops.

## Compilation and Execution Instructions (macOS / Linux)
Compile any program using Apple Clang or GCC:
```bash
clang bubble_sort.c -o bubble_sort && ./bubble_sort
clang linear_search.c -o linear_search && ./linear_search
clang factorial_recursion.c -o factorial_recursion && ./factorial_recursion
clang file_io.c -o file_io && ./file_io
clang matrix_multiplication.c -o matrix_multiplication && ./matrix_multiplication
```
EOF
```

### Step 5: Stage and Commit the Initial Codebase
Inspect the status of unversioned files, stage them, and create the initial commit:

```bash
# Check working directory status
git status

# Stage all files
git add .

# Verify staged files
git status

# Commit changes to local repository
git commit -m "feat: initial commit with 5 fundamental C algorithms and documentation"
```
* **Explanation:**
  * `git status`: Displays untracked, modified, or staged files.
  * `git add .`: Stages all newly created or modified files in the current directory.
  * `git commit -m "..."`: Creates an immutable commit snapshot containing the staged files with the specified message.
* **Expected Output:**
  ```text
  [main (root-commit) 3d8b1e4] feat: initial commit with 5 fundamental C algorithms and documentation
   6 files changed, 138 insertions(+)
   create mode 100644 README.md
   create mode 100644 bubble_sort.c
   create mode 100644 factorial_recursion.c
   create mode 100644 file_io.c
   create mode 100644 linear_search.c
   create mode 100644 matrix_multiplication.c
  ```

### Step 6: Link Local Repository to Remote GitHub and Push
1. Open [https://github.com](https://github.com) in your web browser.
2. Click **New Repository** -> Repository Name: `C-Programs-Library` -> Keep it Public -> Do **NOT** initialize with README or .gitignore (since we already created them locally).
3. Connect and push your local branch:

```bash
# Add remote origin URL (Replace with your actual GitHub username)
git remote add origin https://github.com/your-username/C-Programs-Library.git

# Ensure default branch is named main
git branch -M main

# Push commits and set upstream tracking
git push -u origin main
```
* **Explanation:**
  * `git remote add origin <url>`: Records an alias `origin` for the remote repository URL in `.git/config`.
  * `git branch -M main`: Renames current branch to `main`.
  * `git push -u origin main`: Uploads local commits to GitHub and associates the local `main` branch with `origin/main` (`-u` flag stands for upstream).

### Step 7: Add Program 6 to Demonstrate Incremental Version Tracking
As required by Task Objective 9 of the lab manual, add a 6th program, commit, and push updates:

```bash
cat << 'EOF' > fibonacci.c
#include <stdio.h>

int fibonacci(int n) {
    if (n <= 0) return 0;
    if (n == 1) return 1;
    return fibonacci(n - 1) + fibonacci(n - 2);
}

int main() {
    int terms = 8;
    printf("DevOps Lab - Fibonacci Sequence (First %d terms):
", terms);
    for (int i = 0; i < terms; i++) {
        printf("%d ", fibonacci(i));
    }
    printf("
");
    return 0;
}
EOF

# Update README.md to document the 6th program
echo "6. \`fibonacci.c\`: Calculates Fibonacci series terms using recursion." >> README.md

# Stage, commit, and push incremental changes
git add fibonacci.c README.md
git commit -m "feat: add recursive Fibonacci series generator program"
git push
```
* **Explanation:**
  * `git push`: Because `-u` was set earlier, `git push` automatically pushes to `origin/main`.
* **Expected Output:**
  ```text
  To https://github.com/your-username/C-Programs-Library.git
     3d8b1e4..9f1a2c3  main -> main
  ```

### Step 8: Verification
Verify commit history:

```bash
git log --oneline --graph --decorate
```
* **Expected Output:**
  ```text
  * 9f1a2c3 (HEAD -> main, origin/main) feat: add recursive Fibonacci series generator program
  * 3d8b1e4 feat: initial commit with 5 fundamental C algorithms and documentation
  ```

---

## 4. Important Commands Reference

| Command | Purpose | Explanation |
| :--- | :--- | :--- |
| `git init` | Initialize repository | Creates the hidden `.git` folder in current directory to begin tracking files. |
| `git status` | Check working tree state | Shows modified, untracked, and staged files compared to last commit. |
| `git add <file>` | Stage file | Adds changes from working directory to the staging index. |
| `git add .` | Stage all changes | Stages all new, modified, and deleted files in the repository tree. |
| `git commit -m "msg"` | Save snapshot | Permanently stores staged changes into repository history with a commit message. |
| `git log --oneline` | View commit history | Displays a concise one-line-per-commit history including SHA hash and summary. |
| `git remote add <name> <url>` | Register remote repository | Links a remote URL (GitHub/GitLab) with an alias (typically `origin`). |
| `git push -u origin <branch>` | Upload commits & track | Pushes local branch commits to remote repository and sets default upstream target. |
| `git diff` | Inspect unstaged changes | Shows line-by-line differences between working directory and staging index. |
| `git checkout -- <file>` / `git restore <file>` | Discard changes | Discards uncommitted modifications in working directory, reverting to last commit. |

---

## 5. Troubleshooting Common Git Errors

1. **Error:** `fatal: not a git repository (or any of the parent directories): .git`
   * **Reason:** You ran a Git command outside a folder initialized with `git init` or `git clone`.
   * **Solution:** Navigate into the project folder (`cd C-Programs-Library`) or run `git init`.
2. **Error:** `fatal: remote origin already exists.`
   * **Reason:** An `origin` remote alias is already defined in `.git/config`.
   * **Solution:** Check current remote using `git remote -v`. Update it using `git remote set-url origin <new-url>`.
3. **Error:** `Support for password authentication was removed on August 13, 2021. Please use a personal access token instead.`
   * **Reason:** GitHub no longer accepts account passwords over HTTPS for git operations.
   * **Solution:** Go to GitHub -> Settings -> Developer Settings -> Personal Access Tokens (Classic) -> Generate token with `repo` scope -> Paste token when prompted for password in terminal, or configure SSH keys (`ssh-keygen -t ed25519 -C "email"`).
4. **Error:** `Author identity unknown *** Please tell me who you are.`
   * **Reason:** Git does not know your name and email.
   * **Solution:** Run `git config --global user.name "Your Name"` and `git config --global user.email "you@example.com"`.

---

## 6. Viva and Interview Questions

### Basic Questions (10)
1. **Q: What is Git?**  
   *A:* Git is a free, open-source distributed version control system designed to handle everything from small to very large projects with speed and data integrity.
2. **Q: Who created Git and why?**  
   *A:* Linus Torvalds in 2005 to manage development of the Linux kernel after proprietary BitKeeper access was revoked.
3. **Q: What is the Staging Area (Index) in Git?**  
   *A:* A holding area where changes are prepared, reviewed, and formatted before committing them permanently to the repository history.
4. **Q: What is a Commit in Git?**  
   *A:* A point-in-time snapshot of the staged files in a repository, uniquely identified by a 40-character SHA hash.
5. **Q: What does the `.git` directory contain?**  
   *A:* All internal metadata, object databases (blobs, trees, commits, tags), branch references, configuration settings, and commit history.
6. **Q: What is the difference between `git add <file>` and `git add .`?**  
   *A:* `git add <file>` stages only the specified file, whereas `git add .` stages all changes (modified, added, deleted) in the current directory and subdirectories.
7. **Q: What is the purpose of `.gitignore`?**  
   *A:* A text file specifying intentionally untracked file patterns (such as build artifacts `*.class`, logs `*.log`, credentials, OS files `.DS_Store`) that Git should ignore.
8. **Q: What is a Remote in Git?**  
   *A:* A reference to a common shared version of the repository hosted on a server or network (e.g., GitHub, GitLab, Bitbucket).
9. **Q: What does `git push -u origin main` do?**  
   *A:* It uploads commits from the local `main` branch to the remote repository `origin` and configures upstream tracking so future commands require only `git push` or `git pull`.
10. **Q: What is the difference between Git and GitHub?**  
    *A:* Git is a command-line version control software tool running locally on a computer. GitHub is a cloud-based web hosting service for Git repositories that adds issue tracking, code review, CI/CD, and collaboration tools.

### Intermediate Questions (10)
11. **Q: How does Git store data internally?**  
    *A:* As a content-addressable directed acyclic graph (DAG) of objects: **Blobs** (file contents), **Trees** (directories and file names), **Commits** (commit metadata and root tree pointer), and **Tags** (human-readable release pointers).
12. **Q: What is the difference between `git fetch` and `git pull`?**  
    *A:* `git fetch` downloads remote commits and branches without modifying your working files. `git pull` performs a `git fetch` followed immediately by a `git merge` into your current branch (`git pull = git fetch + git merge`).
13. **Q: What is a detached HEAD state?**  
    *A:* A state where the `HEAD` pointer points directly to a specific commit hash rather than to a named branch. Any new commits made in this state are orphaned if you switch branches without creating a new branch.
14. **Q: What is the difference between `git reset` and `git revert`?**  
    *A:* `git reset` moves the branch pointer backward, rewriting history (dangerous for shared branches). `git revert` creates a new inverse commit that safely undoes changes without rewriting commit history.
15. **Q: What are the differences between `git reset --soft`, `--mixed`, and `--hard`?**  
    *A:* `--soft` resets the commit history but preserves changes in the Staging Area; `--mixed` (default) resets the commit history and un-stages changes into the Working Directory; `--hard` wipes out changes from both history, staging area, and working directory.
16. **Q: How does Git compute file integrity?**  
    *A:* Using SHA-1 (or SHA-256) cryptographic hashing. If a single byte of a file changes, its resulting hash changes completely, preventing silent data corruption.
17. **Q: What does `git stash` do?**  
    *A:* Temporarily shelves (stashes) uncommitted dirty working directory changes so you can switch branches cleanly without losing unfinished work.
18. **Q: How do you inspect differences before committing?**  
    *A:* `git diff` shows differences between Working Directory and Staging Area; `git diff --staged` (or `--cached`) shows differences between Staging Area and last commit.
19. **Q: What is the difference between fast-forward merge and 3-way merge?**  
    *A:* Fast-forward simply moves the branch pointer forward when there are no divergent commits on the target branch. A 3-way merge uses two branch heads and their common ancestor commit to create a new merge commit.
20. **Q: How can you change the most recent commit message?**  
    *A:* `git commit --amend -m "New commit message"` modifies the last commit (only safe if not yet pushed to a remote).

### Practical Scenario-Based Questions (5)
21. **Scenario:** *A developer accidentally committed a secret API token to a local Git repository but has not yet pushed to GitHub. How should they fix it?*  
    *Answer:* Run `git reset --soft HEAD~1`. This undoes the commit while keeping all changes in the staging area. Remove the secret token from the file, add the secret file to `.gitignore`, re-stage, and commit safely.
22. **Scenario:** *You are in the middle of writing a complex function in `bubble_sort.c` when your manager asks you to urgently fix a typo in `README.md` on another branch. What do you do?*  
    *Answer:* Run `git stash save "WIP: bubble sort refactor"`. Switch branches (`git checkout main`), make the fix, commit, and push. Return to your working branch (`git checkout feature-branch`) and run `git stash pop` to restore your exact working state.
23. **Scenario:** *Two developers push commits touching completely different files to the same remote branch. What happens when the second developer runs `git push`?*  
    *Answer:* Git rejects the push with `[rejected - non-fast-forward]` because the second developer's local branch is behind remote. The developer must run `git pull` (or `git pull --rebase`), resolve any conflicts, and then `git push`.
24. **Scenario:** *A junior engineer ran `git add .` and staged large binary dataset files (`data.zip`, 500MB). How do they un-stage them before committing?*  
    *Answer:* Run `git restore --staged data.zip` (or `git reset HEAD data.zip`). Add `data.zip` to `.gitignore` to prevent future accidental staging.
25. **Scenario:** *An engineer needs to find which specific commit introduced a crash bug in production out of 200 commits. What Git tool should they use?*  
    *Answer:* Use `git bisect`. It uses binary search between a known good commit and bad commit, checking out intermediate commits and prompting the engineer to test until the exact offending commit is isolated.

---

## 7. Real-World Applications
* **Monorepos & Polyrepos:** Google, Meta, and Microsoft manage billions of lines of code using Git-based version control infrastructure.
* **Open Source Development:** The Linux Kernel, Kubernetes, Python, and React are maintained by thousands of distributed contributors across the globe using Git.
* **Auditability & Compliance:** Financial institutions use Git commit history and GPG-signed commits to prove regulatory compliance for every code change.

---

# Experiment 3: Collaborating on Projects using GitHub and Pull Requests

## 1. Experiment Overview
* **Experiment Number:** 03
* **Title:** Collaborating on Projects using GitHub and Pull Requests
* **Course Outcome:** CO2 – Apply version control tools and collaborative workflows to software repositories.
* **Aim:** To understand team collaboration patterns on a shared codebase hosted on GitHub by cloning, branching, authoring isolated feature code, opening Pull Requests (PRs), conducting peer code reviews, merging changes, and syncing upstream updates locally.
* **Objectives:**
  1. To understand centralized vs. distributed remote collaboration models (Direct Push vs. Forking/Pull Request model).
  2. To clone an existing shared repository and inspect remote tracking branches.
  3. To author feature changes inside an isolated feature branch (`feature/my-new-feature`).
  4. To open, document, and submit a GitHub Pull Request with clear description and diff summary.
  5. To perform code review, comment on lines, approve changes, and execute a GitHub merge.
  6. To synchronize the local `main` branch with the merged remote changes.
* **Tools and Technologies Required:** macOS Terminal, Git CLI, GitHub Account, VS Code / Any Code Editor, Web Browser.
* **Prerequisites:** Completion of Experiment 2 (Basic Git commands and GitHub repository creation).

---

## 2. Concepts & Theoretical Background

### 2.1 Why the Pull Request (PR) Model?
In enterprise software development, developers are rarely permitted to push code directly to the production or `main` branch. Unchecked direct pushes lead to broken builds, broken production deployments, and unvetted code vulnerabilities.

```
+-------------------------------------------------------------------------------+
|                            GITHUB PULL REQUEST LIFECYCLE                      |
|                                                                               |
|  1. Clone / Fork Repo ---> 2. Create Branch: feature/user-profile             |
|                                         |                                     |
|                                  Make Edits & Commit                          |
|                                         |                                     |
|                               3. git push origin feature/user-profile         |
|                                         |                                     |
|                                         v                                     |
|                            4. Open Pull Request (PR)                          |
|                                         |                                     |
|                      +------------------+------------------+                  |
|                      |                                     |                  |
|               Automated CI Checks                   Peer Code Review          |
|             (Tests, Linters, Build)              (Comments, Approvals)        |
|                      |                                     |                  |
|                      +------------------+------------------+                  |
|                                         |                                     |
|                                         v                                     |
|                            5. Merge PR into main branch                       |
|                                         |                                     |
|                            6. git pull origin main (Sync)                     |
+-------------------------------------------------------------------------------+
```

### 2.2 Key Collaboration Terminology
* **Clone:** Creating an exact local copy of an existing remote repository on your computer.
* **Fork:** Creating a server-side personal copy of someone else's GitHub repository under your own GitHub account.
* **Upstream vs. Origin:**
  * `origin`: Your immediate clone/fork target on GitHub.
  * `upstream`: The original canonical repository created by the core maintainer team.
* **Pull Request (PR):** A proposed set of changes submitted by a developer requesting the repository maintainers review, test, and merge the branch into the base branch.
* **Merge Strategies on GitHub:**
  * **Create a merge commit:** Preserves all individual commits and creates a merge commit with two parents.
  * **Squash and merge:** Combines all commits in the PR branch into a single clean commit on the target branch.
  * **Rebase and merge:** Replays all commits individually onto the tip of the target branch without creating a merge commit.

---

## 3. Complete Implementation: GitHub Team Collaboration Workflow

### Directory Context
Open macOS Terminal. Ensure you are in your project workspace directory (e.g., `~/Desktop/devops-lab`):

```bash
cd ~/Desktop/devops-lab
```

### Step 1: Create Starter Project on GitHub
1. On GitHub, create a repository named `DevOps-Collaboration-Demo`.
2. Add a basic `index.html` file so the repository is initialized with a default `main` branch.

### Step 2: Clone the Shared Repository Locally
Clone the repository to your Mac:

```bash
# Clone the repository (Replace with actual repository URL)
git clone https://github.com/your-username/DevOps-Collaboration-Demo.git

# Navigate into the cloned folder
cd DevOps-Collaboration-Demo
```
* **Explanation:**
  * `git clone <url>`: Downloads the entire project history, files, and branches from GitHub into a local directory and automatically sets up remote tracking for `origin`.
* **Expected Output:**
  ```text
  Cloning into 'DevOps-Collaboration-Demo'...
  remote: Enumerating objects: 3, done.
  remote: Compressing objects: 100% (2/2), done.
  remote: Total 3 (delta 0), reused 0 (delta 0)
  Receiving objects: 100% (3/3), done.
  ```

### Step 3: Create and Checkout an Isolated Feature Branch
Never make feature changes directly on `main`. Create a dedicated feature branch:

```bash
# Verify current branch is main
git branch

# Create and switch to new feature branch
git checkout -b feature/my-new-feature

# Verify current active branch
git branch
```
* **Explanation:**
  * `git checkout -b <branch-name>`: Creates a new branch pointing to the current commit and immediately checks it out (switches to it).
* **Expected Output:**
  ```text
  Switched to a new branch 'feature/my-new-feature'
  ```

### Step 4: Make Code Changes
Open the repository in your editor and add a new module or feature file:

```bash
# Launch VS Code in current directory
code .

# Create a new feature script: app.js
cat << 'EOF' > app.js
// DevOps Collaboration Demo Feature Module
function calculateTeamVelocity(storyPoints, sprintDays) {
    if (sprintDays <= 0) return 0;
    return (storyPoints / sprintDays).toFixed(2);
}

console.log("DevOps Collaboration Feature Loaded Successfully.");
console.log("Sprint Velocity: " + calculateTeamVelocity(45, 10) + " points/day");
EOF
```

### Step 5: Stage, Commit, and Push the Feature Branch to GitHub
Commit the changes locally and push the branch to the remote repository on GitHub:

```bash
# Check status
git status

# Stage the new file
git add app.js

# Commit with a descriptive message
git commit -m "feat(analytics): add team velocity calculation utility"

# Push the feature branch to GitHub
git push origin feature/my-new-feature
```
* **Explanation:**
  * `git push origin feature/my-new-feature`: Creates the branch on GitHub and pushes all new local commits to that specific remote branch without touching `origin/main`.
* **Expected Output:**
  ```text
  Enumerating objects: 4, done.
  Counting objects: 100% (4/4), done.
  Writing objects: 100% (3/3), 420 bytes | 420.00 KiB/s, done.
  Total 3 (delta 0), reused 0 (delta 0)
  remote: Create a pull request for 'feature/my-new-feature' on GitHub by visiting:
  remote:      https://github.com/your-username/DevOps-Collaboration-Demo/pull/new/feature/my-new-feature
  To https://github.com/your-username/DevOps-Collaboration-Demo.git
   * [new branch]      feature/my-new-feature -> feature/my-new-feature
  ```

### Step 6: Create Pull Request (PR) on GitHub
1. Open your browser and navigate to the repository on GitHub.
2. Notice the yellow banner: **"feature/my-new-feature had recent pushes ... Compare & pull request"**.
3. Click **Compare & pull request**.
4. Configure the PR:
   * **Base:** `main`  <--  **Compare:** `feature/my-new-feature`
   * **Title:** `feat(analytics): add team velocity calculation utility`
   * **Description:**
     ```markdown
     ### Summary of Changes
     * Implemented `calculateTeamVelocity` function in `app.js`.
     * Added logging for automated velocity reporting.
     
     ### Verification
     * Tested locally with sample inputs (45 points, 10 sprint days).
     * Expected output verified: 4.50 points/day.
     ```
5. Click **Create Pull Request**.

### Step 7: Code Review, Approval, and Merging
1. In a team setting, a peer engineer or repository owner opens the **Files changed** tab.
2. The reviewer inspects lines of code, leaves inline comments (e.g., "Consider adding input validation for negative story points"), and submits a review with **Approve**.
3. Once approved and automated status checks pass, click **Merge pull request** -> **Confirm merge**.
4. The PR status changes to **Merged** (purple badge). Click **Delete branch** on GitHub to keep the repository clean.

### Step 8: Synchronize Local Repository with Merged Upstream
Now that `main` on GitHub has been updated with the merged changes, pull the latest changes into your local machine:

```bash
# Switch back to local main branch
git checkout main

# Pull latest merged changes from GitHub
git pull origin main

# Delete the local feature branch that is now merged
git branch -d feature/my-new-feature

# Verify that app.js is now present on local main branch
ls -l app.js
```
* **Explanation:**
  * `git checkout main`: Switches active working branch back to `main`.
  * `git pull origin main`: Fetches and merges the latest commits from GitHub's `main` into your local `main`.
  * `git branch -d <name>`: Safely deletes the local branch now that its commits exist in `main`.
* **Expected Output:**
  ```text
  Updating 1a2b3c4..5e6f7g8
  Fast-forward
   app.js | 8 ++++++++
   1 file changed, 8 insertions(+)
   create mode 100644 app.js
  Deleted branch feature/my-new-feature (was 3d4e5f6).
  ```

---

## 4. Important Commands Reference

| Command | Purpose | Explanation |
| :--- | :--- | :--- |
| `git clone <url>` | Clone repository | Downloads remote repository with complete history into a new local directory. |
| `git checkout -b <branch>` | Create and switch branch | Creates a new branch from current commit and switches working directory to it. |
| `git branch` | List local branches | Lists all local branches, with an asterisk `*` indicating the currently active branch. |
| `git branch -a` | List all branches | Lists local branches as well as all remote tracking branches (`remotes/origin/...`). |
| `git push origin <branch>` | Push branch to remote | Creates or updates the named branch on the remote server (`origin`). |
| `git pull origin main` | Fetch & merge remote updates | Downloads changes from remote `main` branch and integrates them into local `main`. |
| `git branch -d <branch>` | Delete merged branch | Safely removes a local branch whose changes have already been merged into `main`. |
| `git branch -D <branch>` | Force delete branch | Deletes a local branch regardless of whether its changes were merged. |
| `git remote -v` | Inspect remote URLs | Lists remote repository names and their associated fetch and push URLs. |

---

## 5. Troubleshooting Common Collaboration Errors

1. **Error:** `fatal: refusing to merge unrelated histories`
   * **Reason:** You attempted to pull from a remote repository that was initialized independently and shares no common commits with your local repository.
   * **Solution:** Run `git pull origin main --allow-unrelated-histories`.
2. **Error:** `error: failed to push some refs to ... Updates were rejected because the remote contains work that you do not have locally.`
   * **Reason:** Another teammate merged changes to the same remote branch since your last pull.
   * **Solution:** Run `git pull --rebase origin <branch>`, test that your code compiles, and run `git push origin <branch>`.
3. **Error:** `There is no tracking information for the current branch.`
   * **Reason:** The local branch does not have an upstream branch configured.
   * **Solution:** Run `git push --set-upstream origin <current-branch-name>`.

---

## 6. Viva and Interview Questions

### Basic Questions (10)
1. **Q: What is a Pull Request (PR)?**  
   *A:* A mechanism in Git hosting platforms (like GitHub) that notifies team members that a developer has completed a feature in a branch and requests review and merging into the target branch.
2. **Q: What is the difference between `git clone` and `git fork`?**  
   *A:* `git clone` is a Git CLI command that copies a remote repository to your local machine. Forking is a GitHub platform action that creates an independent server-side copy of a repository in your GitHub account.
3. **Q: What is the purpose of Branch Protection Rules in GitHub?**  
   *A:* They enforce quality controls on sensitive branches (like `main`), requiring passing CI builds, PR reviews, code owner approvals, and preventing force pushes or branch deletion.
4. **Q: What does `git checkout -b <name>` do?**  
   *A:* It combines two operations: `git branch <name>` (creates the branch) and `git checkout <name>` (switches active working tree to that branch).
5. **Q: What is code review?**  
   *A:* The systematic examination of computer source code by peers before it is merged into the shared codebase to catch bugs, improve readability, and ensure compliance with coding standards.
6. **Q: What is the difference between `origin` and `upstream`?**  
   *A:* `origin` points to your personal fork/clone repository on GitHub, while `upstream` points to the original parent repository from which the fork was derived.
7. **Q: What is Squash and Merge?**  
   *A:* A merge strategy that condenses all individual commits from a feature branch into a single commit on the target branch, keeping the `main` branch commit history clean and linear.
8. **Q: Why should developers avoid committing directly to the `main` branch?**  
   *A:* Direct commits bypass code review and automated CI tests, risking breaking the production build for the entire organization.
9. **Q: How do you delete a remote branch after merging?**  
   *A:* Run `git push origin --delete <branch-name>` or click "Delete branch" in the GitHub PR web UI.
10. **Q: What is a Draft Pull Request in GitHub?**  
    *A:* A PR opened early to share ongoing work and gather initial feedback without allowing it to be merged until marked as "Ready for review".

### Intermediate Questions (10)
11. **Q: What is the difference between Rebase and Merge?**  
    *A:* `git merge` combines branches by creating a new merge commit preserving exact history and branch timelines. `git rebase` rewrites history by moving the entire feature branch so it begins at the tip of the target branch, creating a perfectly linear history.
12. **Q: When should you NOT use `git rebase`?**  
    *A:* The Golden Rule of Rebasing: Never rebase commits that have already been pushed to a public or shared branch, as it rewrites commit hashes and causes synchronization conflicts for teammates.
13. **Q: How does GitHub enforce CI/CD status checks on Pull Requests?**  
    *A:* Through webhook integrations with CI servers (e.g., Jenkins, GitHub Actions). The CI server executes builds and tests on the PR branch and reports a status (`pending`, `success`, or `failure`) back to the GitHub PR.
14. **Q: What is a `CODEOWNERS` file in a GitHub repository?**  
    *A:* A configuration file located at `.github/CODEOWNERS` that automatically assigns designated team members as required code reviewers whenever files matching specific paths are modified in a PR.
15. **Q: How can you update a local feature branch with the latest changes from `main`?**  
    *A:* Checkout your feature branch and run either `git merge main` (creates a merge commit) or `git rebase main` (replays your commits on top of current `main`).
16. **Q: What is a fast-forward merge and when is it possible?**  
    *A:* A merge where the target branch has no new commits since the feature branch was branched off. Git simply moves the target branch pointer forward to the tip of the feature branch.
17. **Q: What is `git fetch` vs `git pull` in the context of remote collaboration?**  
    *A:* `git fetch` retrieves metadata and commits from the remote repository without touching your working tree files. `git pull` fetches remote commits and immediately merges them into your current branch.
18. **Q: How do you review a colleague's PR locally on your computer?**  
    *A:* Run `git fetch origin pull/<PR_ID>/head:pr-<PR_ID>` and then `git checkout pr-<PR_ID>`, or use the GitHub CLI: `gh pr checkout <PR_ID>`.
19. **Q: What is Cherry-Picking in Git?**  
    *A:* Applying the exact changes introduced by a specific commit from one branch onto another branch using `git cherry-pick <commit-hash>`.
20. **Q: How do GitHub Issue keywords automate PR closing?**  
    *A:* Writing phrases like `Closes #12`, `Fixes #34`, or `Resolves #56` in the PR description automatically closes the referenced issue once the PR is merged into `main`.

### Practical Scenario-Based Questions (5)
21. **Scenario:** *A colleague submits a PR with 20 commits containing messages like "fix typo", "oops", "test again". Management wants clean history on `main`. How should you merge it?*  
    *Answer:* Use the **Squash and Merge** strategy on GitHub. This combines all 20 commits into a single high-level commit (e.g., `feat(auth): add OAuth2 login support`) on `main` while preserving the detailed commits in the closed PR discussion for historical reference.
22. **Scenario:** *You opened a PR, but your colleague merged a conflicting PR into `main` before yours. GitHub reports "This branch has conflicts that must be resolved". How do you resolve it?*  
    *Answer:* Checkout your branch locally (`git checkout feature/branch`), pull latest `main` (`git pull origin main`), open the conflicted files, manually resolve the conflict markers (`<<<<<<<`, `=======`, `>>>>>>>`), stage the files (`git add .`), commit (`git commit -m "Merge main and resolve conflicts"`), and `git push origin feature/branch`. The PR automatically updates and unlocks the merge button.
23. **Scenario:** *An engineer pushed an API secret in a PR branch. The PR has NOT been merged. Is the secret safe if they simply push another commit deleting the secret?*  
    *Answer:* No. The secret remains embedded in the git commit history of that branch. The engineer must rewrite the branch history using `git reset` or `git filter-repo` / BFG Repo-Cleaner to completely expunge the secret commit, force-push the cleaned branch (`git push --force-with-lease`), and immediately revoke/rotate the secret on the provider service.
24. **Scenario:** *A critical production bug is detected that was introduced by a merged PR. How can you undo the entire PR safely on GitHub?*  
    *Answer:* On the closed PR page on GitHub, click the **Revert** button. GitHub automatically creates a new branch and PR with a revert commit that inverses every change introduced by the original PR. Review, merge the revert PR, and trigger the deployment pipeline.
25. **Scenario:** *A team of 15 developers collaborates on a large web application. What GitHub workflow prevents breaking regressions from hitting production?*  
    *Answer:* Implement branch protection on `main` and `develop`: Require minimum 2 approving reviews, require passing automated CI builds (JUnit tests, SonarQube quality gate, build check), require signed commits, and forbid direct pushes.

---

## 7. Real-World Applications
* **Open Source Ecosystems:** Kubernetes and VS Code process hundreds of community Pull Requests daily using automated CI validation and bot-assisted triage.
* **Continuous Integration Integration:** Pull Requests trigger automated Jenkins or GitHub Actions pipelines that spin up isolated preview environments for quality assurance before code merges.

---

# Experiment 4: Implementing GitFlow Workflow in a Team-Based Scenario

## 1. Experiment Overview
* **Experiment Number:** 04
* **Title:** Implementing GitFlow Workflow in a Team-Based Scenario
* **Course Outcome:** CO2 – Apply version control tools and collaborative workflows to software repositories.
* **Aim:** To simulate a real-world enterprise engineering team environment and implement the **GitFlow** branching model to manage concurrent feature development, scheduled release staging, and urgent production hotfixes without destabilizing production code.
* **Objectives:**
  1. To understand the GitFlow branching architecture and the role of long-lived branches (`main`, `develop`) and transient branches (`feature/*`, `release/*`, `hotfix/*`).
  2. To initialize and establish the `develop` baseline branch from `main`.
  3. To author feature changes inside `feature/*` and integrate them into `develop` via Pull Requests.
  4. To cut a `release/v1.0` branch, prepare release artifacts, merge into `main` and `develop`, and create GitHub Releases.
  5. To create an urgent `hotfix/bug-4` branch from `main`, apply the patch, and back-merge into both `main` and `develop`.
* **Tools and Technologies Required:** macOS Terminal, Git CLI, GitHub Account, VS Code / Code Editor.
* **Prerequisites:** Completion of Experiment 2 and 3 (Git fundamentals and GitHub PR workflows).

---

## 2. Concepts & Theoretical Background

### 2.1 The GitFlow Branching Model
Published by Vincent Driessen in 2010, GitFlow is a robust branching framework tailored for software projects with scheduled release cycles.

```
   (hotfix/bug-4) -----------------------------+
         ^                                      |
         |                                      v
  [ main ] ------------------------------* (v1.0) -------* (v1.0.1) ------------
     |                                   ^               ^
     |                                   |               |
     v                             [ release/v1.0 ]      |
  [ develop ] -------*-----------*-------+---------------+----------------------
         |           ^           ^
         |           |           |
         +--> [ feature/auth ] --+
```

### 2.2 Branch Categories in GitFlow
1. **Permanent (Long-Lived) Branches:**
   * `main`: Reflects production-ready state. Only production releases and hotfixes enter `main`. Every commit on `main` is tagged with a release version (e.g., `v1.0.0`).
   * `develop`: The central integration branch for features. Reflects latest delivered development changes for the next upcoming release.
2. **Temporary (Supporting) Branches:**
   * `feature/*`: Branched off `develop`. Used to develop specific new user features. Merges back into `develop` when complete.
   * `release/*`: Branched off `develop` when all features for a planned version are complete. Used for final testing, bug fixing, and documentation polish. Merges into both `main` and `develop`.
   * `hotfix/*`: Branched directly off `main` to address critical production emergencies. Merges immediately into both `main` and `develop`.

---

## 3. Complete Implementation: GitFlow Simulation Step-by-Step

### Directory Context
Open macOS Terminal. Navigate to your workspace directory (e.g., `~/Desktop/devops-lab`):

```bash
cd ~/Desktop/devops-lab
```

### Step 1: Clone Repository and Inspect Branches
Clone the repository or use an existing GitHub repository created for team simulation:

```bash
git clone https://github.com/your-username/DevOps-GitFlow-Demo.git
cd DevOps-GitFlow-Demo

# List local branches
git branch
```
* **Explanation:**
  * `git branch`: Displays currently available local branches. Currently only `main` exists.
* **Expected Output:**
  ```text
  * main
  ```

### Step 2: Establish the Central Development Branch (`develop`)
Branch off `main` to create the long-lived `develop` branch and push it to GitHub:

```bash
# Create and switch to develop branch
git checkout -b develop

# Verify active branch
git branch

# Push develop to GitHub
git push -u origin develop
```
* **Explanation:**
  * `git checkout -b develop`: Creates the `develop` integration branch from the current HEAD of `main`.
  * `git push -u origin develop`: Establishes `develop` on the remote repository with upstream tracking.
* **Expected Output:**
  ```text
  Switched to a new branch 'develop'
  * develop
    main
  Total 0 (delta 0), reused 0 (delta 0)
  To https://github.com/your-username/DevOps-GitFlow-Demo.git
   * [new branch]      develop -> develop
  ```

### Step 3: Implement Initial Base Application on `develop`
Add a core application file to `develop`, stage, commit, and push:

```bash
cat << 'EOF' > app.py
# Core Student Portal Application - GitFlow Simulation
print("========================================")
print("  Student Portal Service v1.0-alpha     ")
print("========================================")

def display_home():
    return "Welcome to the Student Portal"

if __name__ == "__main__":
    print(display_home())
EOF

# Stage, commit, and push to develop
git status
git add .
git commit -m "feat(core): initialize student portal application structure"
git push origin develop
```

### Step 4: Create and Implement a Feature Branch (`feature/*`)
Simulate a developer tasked with adding student registration functionality:

```bash
# Ensure we are branching off latest develop
git checkout develop
git pull origin develop

# Create feature branch
git checkout -b feature/student-registration

# Add new feature code
cat << 'EOF' >> app.py

def register_student(student_id, name):
    return f"Student {name} (ID: {student_id}) registered successfully!"
EOF

# Stage and commit feature
git add app.py
git commit -m "feat(registration): add student registration functionality"

# Push feature branch to GitHub
git push -u origin feature/student-registration
```
* **Explanation:**
  * `git checkout -b feature/student-registration`: Isolates new work so `develop` remains clean while the feature is under construction.

### Step 5: Merge Feature into `develop` via Pull Request
1. On GitHub, navigate to **Pull requests** -> **New pull request**.
2. Set **Base:** `develop`  <--  **Compare:** `feature/student-registration`.
3. Title: `feat: integrate student registration module`.
4. Click **Create pull request** -> Review diff -> Click **Merge pull request** -> **Confirm merge**.
5. Delete the remote feature branch.

### Step 6: Create Release Branch (`release/v1.0`)
When all features for version 1.0 are merged into `develop`, create a release branch:

```bash
# Pull merged features into local develop
git checkout develop
git pull origin develop

# Cut release branch from develop
git checkout -b release/v1.0

# Update version numbers and release notes in code
cat << 'EOF' > version.txt
Version: 1.0.0
Release Name: Genesis
Release Date: 2026-11-17
Features Included:
- Student portal home page
- Student registration module
EOF

# Commit release preparations
git add version.txt
git commit -m "chore(release): bump version to 1.0.0 and prepare release notes"

# Push release branch to GitHub
git push -u origin release/v1.0
```

### Step 7: Merge Release Branch into `main` and `develop`
A release must be merged into `main` (for production) AND back into `develop` (so any release-stage bug fixes are preserved in development).
1. **Merge into `main`:**
   * Open PR on GitHub: **Base:** `main`  <--  **Compare:** `release/v1.0`.
   * Title: `Release v1.0.0 Production Deployment`.
   * Merge and confirm.
2. **Merge into `develop`:**
   * Open PR on GitHub: **Base:** `develop`  <--  **Compare:** `release/v1.0`.
   * Merge and confirm.
3. Delete the `release/v1.0` branch on GitHub.

### Step 8: Create an Urgent Production Hotfix (`hotfix/bug-4`)
A critical bug is discovered in production on `main`: The portal crashes when registration receives empty parameters. A hotfix must branch directly from `main`!

```bash
# Switch to main and pull the latest release v1.0
git checkout main
git pull origin main

# Cut hotfix branch directly from main
git checkout -b hotfix/bug-4

# Fix the bug in app.py
cat << 'EOF' > app.py
# Core Student Portal Application - Patched v1.0.1
print("========================================")
print("  Student Portal Service v1.0.1 (Hotfix) ")
print("========================================")

def display_home():
    return "Welcome to the Student Portal"

def register_student(student_id, name):
    if not student_id or not name:
        return "Error: Student ID and Name cannot be empty!"
    return f"Student {name} (ID: {student_id}) registered successfully!"

if __name__ == "__main__":
    print(display_home())
    print(register_student(101, "Atharv"))
    print(register_student(None, None))
EOF

# Commit the emergency patch
git add app.py
git commit -m "fix(security): resolve bug-4 null pointer in student registration"

# Push hotfix branch to GitHub
git push -u origin hotfix/bug-4
```

### Step 9: Merge Hotfix into Both `main` and `develop`
1. Open PR on GitHub: **Base:** `main`  <--  **Compare:** `hotfix/bug-4` -> Merge and confirm.
2. Open PR on GitHub: **Base:** `develop`  <--  **Compare:** `hotfix/bug-4` -> Merge and confirm.
3. Delete the `hotfix/bug-4` branch.

### Step 10: Publish Formal GitHub Release (`v1.0.0`)
As highlighted in Step 16 of the laboratory manual:
1. On GitHub, navigate to the main repository page.
2. On the right-hand sidebar, locate **Releases** and click **Create a new release** (or **Draft a new release**).
3. Fill in the release details:
   * **Choose a tag:** Type `v1.0.0` and click **Create new tag: v1.0.0 on publish**.
   * **Target:** `main`.
   * **Release title:** `Release v1.0.0 - Production Launch`.
   * **Description:**
     ```markdown
     ## Changelog v1.0.0
     * Added student portal home page and greeting service.
     * Integrated student registration utility.
     * Verified zero regression errors.
     ```
4. Click **Publish release**.

---

## 4. Important Commands Reference

| Command | Purpose | Explanation |
| :--- | :--- | :--- |
| `git checkout -b develop` | Create develop branch | Creates and switches to the central integration branch for all new features. |
| `git checkout -b feature/<name>` | Create feature branch | Cuts a feature branch off `develop` to isolate feature work. |
| `git checkout -b release/<v>` | Create release branch | Cuts a release branch off `develop` to stabilize, test, and polish a scheduled release. |
| `git checkout -b hotfix/<id>` | Create hotfix branch | Cuts an emergency fix branch directly off `main` to address critical production issues. |
| `git tag -a v1.0.0 -m "msg"` | Create annotated tag | Marks a specific production commit on `main` with an immutable version tag. |
| `git push origin --tags` | Push tags to GitHub | Uploads all locally created release tags to the remote GitHub repository. |
| `git branch -r` | List remote branches | Displays all branches currently hosted on the remote server (`origin/develop`, etc.). |
| `git branch --merged` | Show merged branches | Lists all branches whose commits have been incorporated into the current checked-out branch. |

---

## 5. Troubleshooting Common GitFlow Errors

1. **Error:** *Accidental direct commits to `main` instead of `develop` or a feature branch.*
   * **Solution:** If not pushed yet, create the intended branch (`git branch feature/my-feature`), then reset `main` back to upstream (`git reset --hard origin/main`), and checkout the new branch (`git checkout feature/my-feature`).
2. **Error:** *Release branch changes not reflected in `develop`.*
   * **Reason:** Developer merged `release/*` into `main` but forgot to back-merge into `develop`.
   * **Solution:** Checkout `develop` (`git checkout develop`), run `git merge release/v1.0` (or merge the release PR into develop on GitHub), and push to `origin/develop`.
3. **Error:** *Hotfix branch conflicts with in-progress features on `develop`.*
   * **Reason:** Code in `develop` has progressed significantly since the hotfixed bug was authored.
   * **Solution:** Resolve merge conflicts in the PR targeting `develop` carefully, ensuring the hotfix logic takes precedence without discarding newly developed features.

---

## 6. Viva and Interview Questions

### Basic Questions (10)
1. **Q: What is GitFlow?**  
   *A:* A standardized Git branching model designed by Vincent Driessen that uses dedicated branches for feature development, release stabilization, and emergency hotfixes.
2. **Q: What are the two primary long-lived branches in GitFlow?**  
   *A:* `main` (stores official production release history) and `develop` (serves as an integration branch for ongoing feature development).
3. **Q: What branch is a `feature/*` branch cut from, and where does it merge?**  
   *A:* It is cut from `develop` and merges back into `develop`.
4. **Q: What branch is a `release/*` branch cut from, and where does it merge?**  
   *A:* It is cut from `develop` and merges into both `main` and `develop`.
5. **Q: What branch is a `hotfix/*` branch cut from, and where does it merge?**  
   *A:* It is cut directly from `main` and merges into both `main` and `develop`.
6. **Q: Why must a hotfix branch merge back into `develop` as well as `main`?**  
   *A:* To ensure that the critical bug fix is included in all future development and does not reappear in the next scheduled release.
7. **Q: What is Semantic Versioning (SemVer)?**  
   *A:* A 3-component version numbering scheme formatted as `MAJOR.MINOR.PATCH` (e.g., `2.1.4`):
   * `MAJOR`: Incompatible API breaking changes.
   * `MINOR`: Backwards-compatible new features.
   * `PATCH`: Backwards-compatible bug fixes.
8. **Q: What is a Git Tag?**  
   *A:* A permanent pointer marking a specific commit in history as important, universally used to mark release milestones (e.g., `v1.0.0`).
9. **Q: What is the difference between a lightweight tag and an annotated tag?**  
   *A:* A lightweight tag is merely a bookmark pointer to a commit. An annotated tag is stored as a full Git object containing author name, email, date, and a cryptographic signature.
10. **Q: Why is GitFlow considered heavy for modern microservices?**  
    *A:* GitFlow involves multiple long-lived branches and complex merges that slow down continuous deployment. Fast-paced web companies often prefer **Trunk-Based Development**.

### Intermediate Questions (10)
11. **Q: What is Trunk-Based Development and how does it compare to GitFlow?**  
    *A:* In Trunk-Based Development, developers merge small, frequent commits into a single `main` branch (the "trunk") multiple times a day using feature flags, avoiding the overhead of long-lived feature and release branches.
12. **Q: Can a developer start new feature development on `develop` while a `release/*` branch is being tested?**  
    *A:* Yes. Because the release branch is branched off `develop`, `develop` is immediately free to receive new feature merges for the *next* future version without contaminating the current release.
13. **Q: What types of changes are allowed on a `release/*` branch?**  
    *A:* Only bug fixes, documentation updates, and release configuration changes (like version number bumps). Large new features are strictly forbidden.
14. **Q: How does GitFlow prevent production regressions?**  
    *A:* By isolating `main` so that code only reaches production through rigorously tested release branches or vetted hotfix branches.
15. **Q: How do you list all tags in a Git repository?**  
    *A:* Run `git tag` or `git tag -l "v1.*"`.
16. **Q: What command pushes all local tags to the remote repository?**  
    *A:* `git push origin --tags`.
17. **Q: How do you delete a tag locally and remotely?**  
    *A:* Locally: `git tag -d <tag_name>`. Remotely: `git push origin --delete <tag_name>`.
18. **Q: What is the difference between GitHub Flow and GitFlow?**  
    *A:* GitHub Flow is a lightweight, simplified model with only `main` and short-lived feature branches that deploy directly to production upon PR merge. GitFlow has two permanent branches (`main`, `develop`) and release/hotfix staging branches.
19. **Q: How do feature flags (toggles) complement or replace GitFlow?**  
    *A:* Feature flags allow uncompleted features to be merged into `main` safely in a disabled state, enabling Trunk-Based Development while eliminating branch drift.
20. **Q: What is "Merge Hell" and how does it occur in GitFlow?**  
    *A:* When multiple feature branches live for weeks or months without integrating into `develop`, their codebases diverge wildly, making the eventual merge agonizing, conflict-ridden, and error-prone.

### Practical Scenario-Based Questions (5)
21. **Scenario:** *A security team reports a critical zero-day vulnerability in production on `v1.2.0`. A release branch `release/v1.3` is currently halfway through QA testing on `develop`. How should the team proceed?*  
    *Answer:* Cut `hotfix/v1.2.1` directly from `main` (`v1.2.0`). Implement and test the security patch. Merge `hotfix/v1.2.1` into `main` and tag `v1.2.1` for immediate production deployment. Then merge `hotfix/v1.2.1` into `release/v1.3` and `develop` so the vulnerability is patched across all tracks.
22. **Scenario:** *A junior developer merged a half-finished, broken feature into `develop`. How should the team recover `develop` without affecting other merged features?*  
    *Answer:* Find the merge commit on `develop` using `git log`, and run `git revert -m 1 <merge-commit-hash>`. This creates a new commit that cleanly reverses the broken feature changes without rewriting shared branch history.
23. **Scenario:** *During release testing on `release/v2.0`, QA identifies a minor visual bug on the login screen. Where should the fix be made?*  
    *Answer:* The fix must be committed directly to the `release/v2.0` branch. When `release/v2.0` is finalized, it will be merged into `main` AND back into `develop`, ensuring the fix propagates to both branches.
24. **Scenario:** *Your company builds mobile apps (iOS/Android) with strict App Store approval schedules and embedded firmware for IoT devices. Is GitFlow or Trunk-Based Development more suitable?*  
    *Answer:* GitFlow is well-suited for mobile and embedded software because software cannot be deployed continuously to end-user devices at will; it requires planned release stabilization, rigorous beta testing, and formal versioned milestones.
25. **Scenario:** *A developer created a feature branch 2 months ago and is finally ready to merge it into `develop`, but 150 commits have occurred on `develop` since. What is the safest way to prepare the branch?*  
    *Answer:* Checkout the feature branch, pull latest `develop`, and run `git merge develop` (or `git rebase develop` if local-only). Resolve all conflicts incrementally and run the entire automated test suite locally before opening the Pull Request.

---

## 7. Real-World Applications
* **Enterprise Banking & Healthcare Software:** Systems that operate under strict regulatory release cycles (quarterly or monthly releases) use GitFlow to manage compliance verification on release branches before touching production.
* **Open-Source Libraries & Frameworks:** Tools like Spring, React Native, and Terraform use versioned release branches to support multiple major and minor versions simultaneously (e.g., maintaining LTS releases `v1.x` while developing `v2.x`).

---

# Experiment 5: Automating Builds and Jobs using Jenkins

## 1. Experiment Overview
* **Experiment Number:** 05
* **Title:** Automating Builds and Jobs using Jenkins
* **Course Outcome:** CO3 – Automate software build, testing, and deployment pipelines using CI tools.
* **Aim:** To learn how to automate software builds and execution jobs using Jenkins automation server, configure Freestyle and Declarative Pipeline jobs, integrate with GitHub source repositories, and configure automated build triggers (Poll SCM and Webhooks).
* **Objectives:**
  1. To understand Jenkins Master/Agent (Controller/Agent) architecture and its central role in CI/CD.
  2. To install, initialize, unlock, and configure Jenkins with essential plugins on macOS using Docker.
  3. To create and configure a **Freestyle Project** to pull Java code from GitHub, compile, and execute it.
  4. To configure scheduled automated polling triggers using cron expressions (`H/5 * * * *`).
  5. To create a modern **Declarative Pipeline** using a versioned `Jenkinsfile`.
  6. To verify automated rebuild execution upon pushing changes to GitHub.
* **Tools and Technologies Required:** macOS Terminal, Docker Desktop, Jenkins LTS Container Image (`jenkins/jenkins:lts`), Git, OpenJDK, Web Browser.
* **Prerequisites:** Completion of Experiment 2 (Git basics) and working knowledge of Java compilation.

---

## 2. Concepts & Theoretical Background

### 2.1 What is Jenkins?
Jenkins is the leading open-source continuous integration and continuous delivery (CI/CD) automation server. It automates every manual phase of software delivery: pulling code from repositories, compiling source code, running automated unit/integration tests, packaging deployable binaries, and deploying to servers.

```
+-----------------------------------------------------------------------------------+
|                            JENKINS DISTRIBUTED ARCHITECTURE                       |
|                                                                                   |
|                                [ JENKINS CONTROLLER ]                             |
|                        (Web UI, Job Scheduler, Config, Plugins)                  |
|                                           |                                       |
|                    +----------------------+----------------------+                |
|                    |                                             |                |
|           (TCP 50000 / SSH / JNLP)                      (TCP 50000 / SSH / JNLP)  |
|                    |                                             |                |
|                    v                                             v                |
|           [ AGENT NODE 1 ]                              [ AGENT NODE 2 ]          |
|      (Linux / Docker Build Agent)                    (macOS / iOS Build Agent)    |
|       - Compiles Java JARs                           - Compiles Swift / Xcode     |
|       - Runs Docker commands                         - Executes device tests      |
+-----------------------------------------------------------------------------------+
```

### 2.2 Core Components of Jenkins
1. **Controller (formerly Master):** Directs the entire pipeline: renders the web UI, parses job configurations, assigns build workloads to agents, and records build logs.
2. **Agents (formerly Slaves):** Dedicated worker machines or ephemeral Docker containers running a lightweight Java process that executes build steps assigned by the controller.
3. **Plugins:** Extensibility modules that allow Jenkins to communicate with external tools (e.g., Git Plugin, Maven Integration Plugin, Docker Pipeline, Slack Notifier).
4. **Jenkins Jobs:**
   * **Freestyle Project:** Classical UI-driven job configuration. Simple to set up for basic scripts but cannot be version-controlled easily.
   * **Pipeline:** Modern "Pipeline as Code" model where the entire build, test, and release workflow is defined inside a script named `Jenkinsfile` committed alongside source code in Git.
   * **Multi-Configuration Project:** Builds the same project across multiple configurations (e.g., multiple OS platforms or JDK versions).

---

## 3. Complete Implementation: Automating Java Builds with Jenkins

### Directory Context
Open macOS Terminal. You will run commands from your home or project directory.

### Step 1: Install and Launch Jenkins using Docker
Running Jenkins in Docker is the industry-recommended, portable method for macOS, eliminating complex host daemon configurations.

```bash
# Create a dedicated named volume for persistent Jenkins data
docker volume create jenkins_home

# Run Jenkins LTS container
docker run -d \
  --name jenkins \
  -p 8080:8080 \
  -p 50000:50000 \
  -v jenkins_home:/var/jenkins_home \
  --restart=unless-stopped \
  jenkins/jenkins:lts
```
* **Explanation:**
  * `-d`: Runs container in detached background mode.
  * `-p 8080:8080`: Maps host port 8080 to container port 8080 (Jenkins Web UI).
  * `-p 50000:50000`: Port used for inbound agent communication via JNLP.
  * `-v jenkins_home:/var/jenkins_home`: Persists all jobs, workspaces, and plugin data across container restarts.
  * `jenkins/jenkins:lts`: Uses the official Long-Term Support release image.
* **Expected Output:**
  ```text
  c7a9b1e4f2... (Container ID)
  ```

### Step 2: Unlock and Set Up Jenkins UI
1. Open your web browser and navigate to: `http://localhost:8080`.
2. The **Unlock Jenkins** screen requests the Administrator password.
3. Retrieve the initial admin password directly from the container logs:

```bash
docker exec jenkins cat /var/jenkins_home/secrets/initialAdminPassword
```
* **Expected Output:**
  ```text
  e92a83f140bd4b9187321a48c731e0b9
  ```
4. Copy and paste the 32-character token into the Jenkins UI and click **Continue**.
5. Select **Install suggested plugins** (automatically installs Git, Pipeline, Timestamper, Credentials Provider).
6. Create your First Admin User (e.g., Username: `admin`, Password: `adminpassword123`, Name: `DevOps Admin`).
7. Confirm the Jenkins URL as `http://localhost:8080/` and click **Save and Finish** -> **Start using Jenkins**.

### Step 3: Create a Simple Java Project on GitHub
Create a sample GitHub repository named `Jenkins_Demo` containing a simple Java application:

```bash
mkdir -p ~/Desktop/devops-lab/Jenkins_Demo
cd ~/Desktop/devops-lab/Jenkins_Demo
git init

# Create HelloWorld.java
cat << 'EOF' > HelloWorld.java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("  Hello from Jenkins Automated CI/CD Pipeline!  ");
        System.out.println("  Build automated by Department of CSE DevOps Lab");
        System.out.println("=================================================");
    }
}
EOF

# Initialize, commit, and push to GitHub
git branch -M main
git add HelloWorld.java
git commit -m "feat: initial java program for jenkins automation"
git remote add origin https://github.com/your-username/Jenkins_Demo.git
git push -u origin main
```

### Step 4: Create a Freestyle Project in Jenkins
1. On the Jenkins Dashboard, click **New Item**.
2. Enter item name: `HelloWorld-Build`.
3. Select **Freestyle project** and click **OK**.
4. **General Tab:** Enter description: `Automated build and test of HelloWorld Java application`.
5. **Source Code Management Tab:**
   * Select **Git**.
   * Repository URL: `https://github.com/your-username/Jenkins_Demo.git`.
   * Branches to build: `*/main`.
6. **Build Triggers Tab:**
   * Check **Poll SCM**.
   * Schedule: `H/5 * * * *` (polls GitHub every 5 minutes for new commits).
7. **Build Steps Tab:**
   * Click **Add build step** -> Select **Execute shell** (or **Execute Windows batch command** on Windows).
   * Enter the shell script:
     ```bash
     echo "Current workspace directory:"
     pwd
     echo "Compiling Java program..."
     javac HelloWorld.java
     echo "Running Java program..."
     java HelloWorld
     ```
8. Click **Save**.

### Step 5: Execute Manual Build and Verify Console Output
1. On the `HelloWorld-Build` job dashboard, click **Build Now**.
2. Notice **#1** appears in the **Build History** box on the bottom left.
3. Click **#1** -> Click **Console Output**.
* **Expected Output:**
  ```text
  Started by user DevOps Admin
  Running as SYSTEM
  Building in workspace /var/jenkins_home/workspace/HelloWorld-Build
  The recommended git tool is: NONE(recommended)
  Using credential(s) none
   > git rev-parse --resolve-git-dir /var/jenkins_home/workspace/HelloWorld-Build/.git # timeout=10
  Cloning the remote Git repository
  Cloning repository https://github.com/your-username/Jenkins_Demo.git
   > git fetch --tags --force --progress -- https://github.com/your-username/Jenkins_Demo.git +refs/heads/*:refs/remotes/origin/* # timeout=10
   > git checkout -f e9b1c2a3... # timeout=10
  Commit message: "feat: initial java program for jenkins automation"
  [HelloWorld-Build] $ /bin/sh -xe /tmp/jenkins8492019482.sh
  + echo Current workspace directory:
  Current workspace directory:
  /var/jenkins_home/workspace/HelloWorld-Build
  + echo Compiling Java program...
  Compiling Java program...
  + javac HelloWorld.java
  + echo Running Java program...
  Running Java program...
  + java HelloWorld
  =================================================
    Hello from Jenkins Automated CI/CD Pipeline!  
    Build automated by Department of CSE DevOps Lab
  =================================================
  Finished: SUCCESS
  ```

### Step 6: Verify Automated Trigger via Poll SCM
1. On your Mac, edit `HelloWorld.java` to modify the output string:
   ```bash
   sed -i '' 's/Hello from Jenkins/Hello from Jenkins (Auto-Triggered Update)/g' HelloWorld.java
   git add HelloWorld.java
   git commit -m "chore: update message to test automated SCM polling"
   git push origin main
   ```
2. Wait up to 5 minutes without touching Jenkins.
3. Observe that build **#2** starts automatically with trigger reason: `Started by an SCM change`.

### Step 7: Pipeline Job Demonstration using Declarative Jenkinsfile
Create a `Jenkinsfile` in the repository to demonstrate the modern "Pipeline as Code" model:

```groovy
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Stage 1: Checking out latest code from GitHub...'
                git branch: 'main', url: 'https://github.com/your-username/Jenkins_Demo.git'
            }
        }
        stage('Build') {
            steps {
                echo 'Stage 2: Compiling Java source files...'
                sh 'javac HelloWorld.java'
            }
        }
        stage('Run') {
            steps {
                echo 'Stage 3: Executing compiled Java application...'
                sh 'java HelloWorld'
            }
        }
    }
    post {
        success {
            echo 'Pipeline completed successfully with zero defects!'
        }
        failure {
            echo 'Pipeline failed! Check console logs.'
        }
    }
}
```

---

## 4. Important Commands Reference

| Command | Purpose | Explanation |
| :--- | :--- | :--- |
| `docker run -d -p 8080:8080 ...` | Start Jenkins container | Spawns a background Jenkins controller container with exposed ports and mounted volume. |
| `docker exec jenkins cat /var/.../initialAdminPassword` | Fetch admin token | Reads the initial unlock password directly from the container file system. |
| `docker logs -f jenkins` | Follow container logs | Streams real-time controller logs to monitor startup, plugin installs, and errors. |
| `docker restart jenkins` | Restart Jenkins service | Gracefully stops and restarts the Jenkins container while preserving data. |
| `H/5 * * * *` | Poll SCM Cron format | Jenkins cron syntax meaning: Run hash-jittered polling every 5 minutes. |

---

## 5. Troubleshooting Common Jenkins Errors

1. **Error:** `javac: command not found` in Build Step
   * **Reason:** The official Jenkins LTS image (`jenkins/jenkins:lts`) comes bundled with a Java JRE to run Jenkins, but does not always include the `javac` compiler in its default `$PATH`.
   * **Solution:** Install JDK on the container via `docker exec -u 0 jenkins apt-get update && docker exec -u 0 jenkins apt-get install -y default-jdk`, or use a custom Dockerfile with JDK pre-installed, or use Maven plugin.
2. **Error:** `Host key verification failed` or `Permission denied (publickey)`
   * **Reason:** Jenkins cannot authenticate with a private GitHub repository.
   * **Solution:** Go to **Manage Jenkins** -> **Credentials** -> Add **Username with password** (using GitHub username and Personal Access Token) and select the credential under Job SCM settings.
3. **Error:** Jenkins Port `8080` Conflict
   * **Reason:** Another service on your Mac (such as an existing Tomcat or development server) is using port 8080.
   * **Solution:** Map to a different host port: `-p 8888:8080`, and access Jenkins at `http://localhost:8888`.

---

## 6. Viva and Interview Questions

### Basic Questions (10)
1. **Q: What is Jenkins?**  
   *A:* An open-source Java-based automation server used to automate software development tasks including building, testing, packaging, and deploying applications.
2. **Q: What is a Freestyle project in Jenkins?**  
   *A:* A traditional UI-configured job where build steps, triggers, and post-build actions are set up manually through forms in the Jenkins web interface.
3. **Q: What is a Jenkins Pipeline?**  
   *A:* A suite of plugins that supports implementing and integrating continuous delivery pipelines into Jenkins using a text file called `Jenkinsfile`.
4. **Q: What are the two types of Jenkins Pipeline syntax?**  
   *A:* Declarative Pipeline (simpler, structured, uses `pipeline {}` blocks) and Scripted Pipeline (older, Groovy-based, uses `node {}` blocks).
5. **Q: What is the Controller (Master) node in Jenkins?**  
   *A:* The central server that manages configurations, schedules build jobs, assigns tasks to agent nodes, and serves the web UI.
6. **Q: What is an Agent (Slave) node in Jenkins?**  
   *A:* An execution engine managed by the controller that actually executes the build commands and scripts in an isolated workspace.
7. **Q: What is Poll SCM?**  
   *A:* A build trigger where Jenkins periodically contacts the version control system (e.g., every 5 minutes) to check if any new commits have been pushed since the last build.
8. **Q: What is a Webhook?**  
   *A:* An event-driven HTTP callback where GitHub sends an immediate POST request to Jenkins the instant a developer pushes code, triggering a build in real time without polling delay.
9. **Q: What is a Jenkins Workspace?**  
   *A:* A dedicated directory on the controller or agent disk where Jenkins clones project source code and runs build commands for a specific job.
10. **Q: Where is Jenkins configuration stored on the filesystem?**  
    *A:* In the `JENKINS_HOME` directory (e.g., `/var/jenkins_home`), stored in human-readable XML configuration files.

### Intermediate Questions (10)
11. **Q: Why is Declarative Pipeline preferred over Scripted Pipeline?**  
    *A:* Declarative syntax is more structured, easier to read and maintain, enforces error handling blocks (`post {}`), and integrates seamlessly with Blue Ocean and stage visualization tools.
12. **Q: What is the purpose of the `post` section in a Declarative Pipeline?**  
    *A:* It executes conditional actions depending on the pipeline outcome (e.g., `always`, `success`, `failure`, `unstable`, `aborted`), commonly used for notifications, test report archiving, and workspace cleanup.
13. **Q: What is the difference between `Build periodically` and `Poll SCM`?**  
    *A:* `Build periodically` triggers the build on a fixed clock schedule regardless of whether code has changed; `Poll SCM` only triggers the build if it detects new commits in the repository.
14. **Q: How does Jenkins manage secrets and credentials securely?**  
    *A:* Using the Jenkins Credentials Store. Secrets (API tokens, passwords, SSH keys) are encrypted on disk and injected into pipelines as masked environment variables that never appear in plain text logs.
15. **Q: What is Blue Ocean in Jenkins?**  
    *A:* A modernized user interface for Jenkins designed from the ground up for Declarative Pipelines, providing intuitive visual representations of pipeline stages and failures.
16. **Q: What is a Multibranch Pipeline in Jenkins?**  
    *A:* A job type that automatically discovers branches and Pull Requests in a Git repository containing a `Jenkinsfile` and creates dedicated pipelines for each branch dynamically.
17. **Q: What does the `H` symbol mean in Jenkins cron schedules (e.g., `H/5 * * * *`)?**  
    *A:* `H` stands for "Hash". It distributes execution times across different jobs based on a hash of the job name, preventing all jobs scheduled for `*/5` from firing at the exact same second and overloading the server.
18. **Q: How can you pass parameters into a Jenkins job?**  
    *A:* By configuring "This project is parameterized" in the job settings, allowing users or automated webhooks to pass strings, booleans, choices, or passwords at build time.
19. **Q: What does `agent any` mean in a Jenkinsfile?**  
    *A:* It instructs Jenkins to run the pipeline on any available executor on any connected agent node or controller.
20. **Q: How can you run stages in parallel in a Declarative Pipeline?**  
    *A:* By nesting a `parallel {}` block inside a `stage {}`, allowing independent stages (e.g., Unit Tests and Integration Tests) to execute concurrently on separate agent executors.

### Practical Scenario-Based Questions (5)
21. **Scenario:** *A build fails in Jenkins, but when the developer runs the exact same command on their local Mac terminal, it succeeds. What are the common causes?*  
    *Answer:* Environment divergence: Difference in JDK or tool versions between developer machine and Jenkins container, missing environment variables (`JAVA_HOME`, `PATH`), missing dependencies in Jenkins workspace, or hardcoded file paths (e.g., `/Users/atharv/...` vs `/var/jenkins_home/...`).
22. **Scenario:** *Your Jenkins server runs out of disk space because builds archive large artifacts on every commit. How do you resolve this permanently?*  
    *Answer:* Configure the "Discard old builds" log rotator policy in job settings (e.g., keep max 10 builds or 7 days). Use the `cleanWs()` step in the `post { always { ... } }` block of the `Jenkinsfile` to clean up temporary workspace files after builds finish.
23. **Scenario:** *A production deployment pipeline requires manual human sign-off before releasing to live servers. How is this achieved in Jenkinsfile?*  
    *Answer:* Use the `input` step:
    ```groovy
    stage('Approval') {
        steps {
            input message: 'Approve deployment to Production?', ok: 'Deploy'
        }
    }
    ```
    This pauses the pipeline until an authorized user clicks "Deploy" in the UI.
24. **Scenario:** *A repository has 50 developers pushing code constantly. Polling SCM every 1 minute causes high CPU usage and hits GitHub API rate limits. What is the solution?*  
    *Answer:* Disable SCM polling entirely and switch to event-driven **GitHub Webhooks**. GitHub sends an immediate lightweight HTTP POST request directly to Jenkins (`http://jenkins-server:8080/github-webhook/`) only when commits actually occur.
25. **Scenario:** *A build job takes 45 minutes because it runs tests on Windows, Linux, and macOS sequentially. How can Jenkins optimize this?*  
    *Answer:* Convert the job into a Pipeline with a `parallel` block, assigning Windows, Linux, and macOS stages to dedicated agents. All three platform test suites execute simultaneously, reducing build duration to the length of the single slowest test suite.

---

## 7. Real-World Applications
* **Automated Continuous Integration:** Thousands of enterprises run Jenkins clusters with hundreds of agents building and running automated regression test suites on thousands of microservices 24/7.
* **Release Orchestration:** Triggering end-to-end release workflows that compile artifacts, sign binaries cryptographically, push containers to registries, and notify engineering teams on Slack or Microsoft Teams.

---

# Experiment 6: Applying CI/CD Principles to Web Development using Jenkins

## 1. Experiment Overview
* **Experiment Number:** 06
* **Title:** Applying CI/CD Principles to Web Development using Jenkins
* **Course Outcome:** CO3 – Automate software build, testing, and deployment pipelines using CI tools.
* **Aim:** To apply Continuous Integration (CI) and Continuous Deployment (CD) principles to modern web development by building an automated pipeline in Jenkins that checks out web assets (HTML/CSS/JS), executes syntax validation/linting tests, deploys the web application to a web server root directory, and verifies availability via HTTP.
* **Objectives:**
  1. To understand the complete web application CI/CD lifecycle from commit to live web page.
  2. To create a modular frontend web application repository (`index.html`, `style.css`, `script.js`).
  3. To author a multi-stage Declarative `Jenkinsfile` encompassing Checkout, Build, Test, Deploy, and Verification stages.
  4. To automate deployment to target web server directories (e.g., Apache/Nginx web roots `/var/www/html` or simulated local server).
  5. To test end-to-end continuous deployment by pushing a UI modification to GitHub and observing automated live deployment without manual intervention.
* **Tools and Technologies Required:** macOS Terminal, Docker Desktop, Jenkins, Python 3 (for lightweight HTTP server testing), Git, GitHub, Web Browser.
* **Prerequisites:** Completion of Experiment 5 (Jenkins fundamentals and pipeline execution).

---

## 2. Concepts & Theoretical Background

### 2.1 The Web CI/CD Pipeline
Web applications require rapid, dependable updates. In a modern web CI/CD pipeline:
1. **Developer commits:** Updates HTML layout, CSS styles, or JavaScript interactions.
2. **CI triggers:** Jenkins pulls code immediately.
3. **Build stage:** Static assets are checked, bundled, or minified.
4. **Test stage:** Automated linters validate HTML syntax (HTML Tidy / W3C validator), CSS linters check stylesheets, and unit tests test JavaScript logic.
5. **Deploy stage:** Files are securely synchronized to the public web server directory (e.g., Nginx, Apache HTTP Server, or cloud object storage like AWS S3).
6. **Verification stage:** An automated smoke test pings the HTTP endpoint to verify the web page returns HTTP 200 OK.

```
+---------------------------------------------------------------------------------------+
|                               WEB APPLICATION CI/CD LIFECYCLE                         |
|                                                                                       |
|  [ Git Push ]                                                                         |
|        |                                                                              |
|        v                                                                              |
|  [ Webhook / SCM Poll ]                                                               |
|        |                                                                              |
|        v                                                                              |
|  [ STAGE 1: Checkout ] --------> Clones HTML, CSS, JS from GitHub                    |
|        |                                                                              |
|        v                                                                              |
|  [ STAGE 2: Build ] -----------> Validates file tree and workspace integrity         |
|        |                                                                              |
|        v                                                                              |
|  [ STAGE 3: Test ] ------------> HTML Syntax validation (tidy / linter check)         |
|        |                                                                              |
|        v                                                                              |
|  [ STAGE 4: Deploy ] ----------> Syncs web assets to web server (/var/www/html)       |
|        |                                                                              |
|        v                                                                              |
|  [ STAGE 5: Verify ] ----------> HTTP Smoke test (curl -I http://localhost/Home.html) |
+---------------------------------------------------------------------------------------+
```

---

## 3. Complete Implementation: Automated Web App Pipeline

### Directory Context
Open macOS Terminal. Navigate to your workspace directory (e.g., `~/Desktop/devops-lab`):

```bash
mkdir -p ~/Desktop/devops-lab/Jenkin_with_HTML
cd ~/Desktop/devops-lab/Jenkin_with_HTML
git init
```

### Step 1: Create the Web Application Files
Create the three standard web assets required by the lab manual:

#### 1. `index.html` (or `Home.html`)
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DevOps Web Application</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <header>
        <h1 id="main-heading">DevOps Student Portal - Continuous Deployment Live</h1>
        <p class="subtitle">Automated Web Deployment with Jenkins CI/CD Pipeline</p>
    </header>
    <main>
        <section class="card">
            <h2>System Health Status</h2>
            <p id="status-text">Checking deployment status...</p>
            <button onclick="checkHealth()">Verify Deployment</button>
        </section>
    </main>
    <footer>
        <p>&copy; 2026 Department of Computer Science & Engineering. All rights reserved.</p>
    </footer>
    <script src="script.js"></script>
</body>
</html>
```

#### 2. `style.css`
```css
body {
    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, sans-serif;
    background-color: #f0f2f5;
    margin: 0;
    padding: 20px;
    color: #333;
}
header {
    background: linear-gradient(135deg, #1e3c72, #2a5298);
    color: white;
    padding: 30px;
    border-radius: 8px;
    text-align: center;
}
.subtitle {
    font-size: 1.1rem;
    opacity: 0.9;
}
.card {
    background: white;
    margin-top: 20px;
    padding: 25px;
    border-radius: 8px;
    box-shadow: 0 4px 6px rgba(0,0,0,0.1);
}
button {
    background-color: #28a745;
    color: white;
    border: none;
    padding: 10px 20px;
    font-size: 1rem;
    border-radius: 5px;
    cursor: pointer;
}
button:hover {
    background-color: #218838;
}
```

#### 3. `script.js`
```javascript
function checkHealth() {
    const statusElem = document.getElementById("status-text");
    const now = new Date();
    statusElem.innerText = "SUCCESS: Application is LIVE and healthy! Timestamp: " + now.toLocaleTimeString();
    statusElem.style.color = "#28a745";
    statusElem.style.fontWeight = "bold";
}

document.addEventListener("DOMContentLoaded", () => {
    console.log("DevOps Web App Script initialized successfully.");
});
```

### Step 2: Create Cross-Platform Declarative `Jenkinsfile`
Author the complete `Jenkinsfile` matching the lab manual requirements, supporting both macOS/Linux and Windows environments:

```groovy
pipeline {
    agent any

    environment {
        // Target deployment directory for web assets
        DEPLOY_DIR = '/var/jenkins_home/deployed_web_app'
    }

    stages {
        stage('Checkout') {
            steps {
                echo '========== STAGE 1: Cloning project from GitHub =========='
                checkout scm
                sh 'ls -la'
            }
        }

        stage('Build') {
            steps {
                echo '========== STAGE 2: Validating workspace files =========='
                sh '''
                    echo "Checking critical frontend files..."
                    test -f index.html || { echo "index.html missing!"; exit 1; }
                    test -f style.css || { echo "style.css missing!"; exit 1; }
                    test -f script.js || { echo "script.js missing!"; exit 1; }
                    echo "All frontend assets verified successfully."
                '''
            }
        }

        stage('Test') {
            steps {
                echo '========== STAGE 3: Executing HTML syntax validation =========='
                sh '''
                    grep -q "<!DOCTYPE html>" index.html || { echo "Missing DOCTYPE!"; exit 1; }
                    grep -q "<html>" index.html || grep -q "<html lang=" index.html || { echo "Missing html tag!"; exit 1; }
                    grep -q "</html>" index.html || { echo "Unclosed html tag!"; exit 1; }
                    echo "HTML syntax validation passed with zero errors!"
                '''
            }
        }

        stage('Deploy') {
            steps {
                echo '========== STAGE 4: Deploying assets to Web Server root =========='
                sh """
                    mkdir -p ${DEPLOY_DIR}
                    cp -v index.html style.css script.js ${DEPLOY_DIR}/
                    echo "Deployment completed to: ${DEPLOY_DIR}"
                """
            }
        }

        stage('Verify Deployment') {
            steps {
                echo '========== STAGE 5: Verifying deployment integrity =========='
                sh """
                    test -f ${DEPLOY_DIR}/index.html
                    echo "Verification confirmed: index.html is present in web server root."
                """
            }
        }
    }

    post {
        success {
            echo 'Pipeline finished successfully! Application is ready for traffic.'
        }
        failure {
            echo 'Pipeline failed! Check console build logs for errors.'
        }
    }
}
```

### Step 3: Push Project to GitHub
Push the complete web application and `Jenkinsfile` to GitHub:

```bash
git branch -M main
git add .
git commit -m "feat: complete web application with multi-stage CI/CD Jenkinsfile"
git remote add origin https://github.com/your-username/Jenkin_with_HTML.git
git push -u origin main
```

### Step 4: Create and Run Pipeline Job in Jenkins
1. Open Jenkins at `http://localhost:8080`.
2. Click **New Item** -> Name: `Web-App-CI-CD` -> Select **Pipeline** -> Click **OK**.
3. Under **Build Triggers**, select **Poll SCM** with schedule: `H/5 * * * *`.
4. Under **Pipeline**:
   * Definition: **Pipeline script from SCM**
   * SCM: **Git**
   * Repository URL: `https://github.com/your-username/Jenkin_with_HTML.git`
   * Branch Specifier: `*/main`
   * Script Path: `Jenkinsfile`
5. Click **Save**.
6. Click **Build Now**.
7. Observe each stage turn bright green in Stage View: **Checkout -> Build -> Test -> Deploy -> Verify Deployment**.

### Step 5: Test Continuous Deployment by Modifying Code on GitHub
1. Edit `index.html` on your Mac (or directly on GitHub):
   ```bash
   sed -i '' 's/DevOps Student Portal/DevOps Student Portal (Version 2.0)/g' index.html
   git add index.html
   git commit -m "chore(ui): update heading to Version 2.0"
   git push origin main
   ```
2. Wait for Jenkins to poll or click **Build Now**.
3. Confirm that Jenkins executes build **#2** automatically and deploys the updated `index.html` file seamlessly!

---

## 4. Important Commands Reference

| Command | Purpose | Explanation |
| :--- | :--- | :--- |
| `test -f <file>` | Test file existence | POSIX shell command that returns exit code 0 if file exists, 1 if missing. |
| `grep -q "<pattern>" <file>` | Search string silently | Searches for a regex pattern in file without printing output; returns exit code 0 on match. |
| `cp -v <src> <dest>` | Verbose copy | Copies files while printing each copied file path to console logs. |
| `python3 -m http.server 8000` | Start quick HTTP server | Spawns a lightweight local HTTP web server serving files from the current directory. |
| `curl -I http://localhost:8000` | Inspect HTTP response | Sends an HTTP HEAD request and prints status code (e.g., `HTTP/1.1 200 OK`) and headers. |

---

## 5. Troubleshooting Common Web CI/CD Errors

1. **Error:** `cp: /var/www/html/: Permission denied`
   * **Reason:** The Jenkins execution user (`jenkins`) does not have write permissions to system web root folders owned by `root` or `www-data`.
   * **Solution:** Grant permissions on target folder (`sudo chown -R jenkins:jenkins /var/www/html`) or deploy inside a user-owned directory / container volume.
2. **Error:** `Grep failed / Exit status 1` during Test stage
   * **Reason:** The HTML file is missing an essential tag (e.g., doctype or closed tag) checked by the test script.
   * **Solution:** Inspect `index.html`, fix the syntax error, test locally with `grep`, and commit the fix.
3. **Error:** Changes visible on GitHub but not in browser after deployment
   * **Reason:** Browser HTTP aggressive caching of static CSS or JavaScript assets.
   * **Solution:** Perform a hard refresh in your browser (`Cmd + Shift + R` on macOS or `Ctrl + F5` on Windows), or use cache-busting version query parameters (e.g., `style.css?v=2.0`).

---

## 6. Viva and Interview Questions

### Basic Questions (10)
1. **Q: What is the main goal of applying CI/CD to web development?**  
   *A:* To automate the testing, integration, and deployment of web assets, enabling rapid, reliable, bug-free web releases with zero manual server configuration.
2. **Q: What are the typical stages in a frontend web CI/CD pipeline?**  
   *A:* Checkout -> Dependency Installation -> Linting/Syntax Validation -> Unit Testing -> Build/Bundling -> Deployment -> Smoke Testing.
3. **Q: What is a Web Server Document Root?**  
   *A:* The public base directory on a server's filesystem where web files (HTML, CSS, JS, images) reside and are served to browsers (e.g., `/var/www/html` in Apache/Nginx).
4. **Q: Why is automated testing essential in web CI/CD?**  
   *A:* It prevents syntax errors, broken links, broken layouts, and JavaScript runtime crashes from reaching production users.
5. **Q: What is HTML Tidy?**  
   *A:* An open-source console utility and library used to clean up, validate, and fix HTML syntax errors and formatting issues.
6. **Q: What is the purpose of the `environment` block in a Jenkinsfile?**  
   *A:* It defines key-value variables globally or per-stage that can be reused across pipeline steps (e.g., target server paths, API URLs).
7. **Q: What is a Smoke Test in web deployment?**  
   *A:* A fast, preliminary health check performed immediately after deployment to verify that the web application started and returns HTTP 200 OK before routing real user traffic.
8. **Q: What is Minification in web builds?**  
   *A:* Removing whitespace, comments, and shortening variable names in HTML, CSS, and JS files to reduce file sizes and accelerate page load speeds.
9. **Q: What is Cache Busting?**  
   *A:* Appending a unique hash or version number to static asset URLs (e.g., `bundle.a7f3c2.js`) to force browsers to download the fresh version rather than using stale cached files.
10. **Q: What does `curl -I <url>` do?**  
    *A:* Fetches only the HTTP response headers of a web endpoint (including status code, content type, and server headers) without downloading the response body.

### Intermediate Questions (10)
11. **Q: What is the difference between deploying to a traditional web server (like IIS/Apache) vs. a Static Web Hosting service (like AWS S3 / Cloudflare Pages)?**  
    *A:* Traditional web servers require managing operating system instances, patching, and process management. Static hosting services are serverless, globally distributed, highly available, and automatically scale with zero infrastructure management.
12. **Q: How can secrets (like deployment SSH keys or AWS access keys) be used in a web Jenkinsfile?**  
    *A:* By storing them in the Jenkins Credentials store and binding them using `withCredentials([sshUserPrivateKey(...)])` or `withCredentials([usernamePassword(...)])`.
13. **Q: What is Blue-Green deployment for a web application?**  
    *A:* Maintaining two identical production environments: "Blue" (active running current live version) and "Green" (idle where new version is deployed and tested). Once verified, the load balancer switches traffic instantly from Blue to Green.
14. **Q: What is Canary Deployment?**  
    *A:* Routing a small percentage of real user traffic (e.g., 5%) to the newly deployed version while the remaining 95% stays on the stable version. If error rates remain low, traffic is gradually increased to 100%.
15. **Q: What is Content Delivery Network (CDN) invalidation in a web CI/CD pipeline?**  
    *A:* An automated pipeline step executed after new files are uploaded that flushes edge cache nodes (e.g., AWS CloudFront, Cloudflare) so worldwide users immediately receive updated assets.
16. **Q: What is Lighthouse CI?**  
    *A:* An automated tool integrated into CI pipelines that scores web pages on Performance, Accessibility, Best Practices, and SEO, failing builds if scores fall below defined thresholds.
17. **Q: How does Jenkins handle build failures in multi-stage pipelines?**  
    *A:* If any command in a stage exits with a non-zero exit code, Jenkins halts execution immediately, marks the stage as failed, skips subsequent stages, and triggers the `post { failure {} }` block.
18. **Q: What is a Reverse Proxy (e.g., Nginx) and why is it used in front of web applications?**  
    *A:* A server that sits between clients and backend web servers, handling SSL termination, load balancing, request compression, static file caching, and DDoS defense.
19. **Q: How can you rollback a failed web deployment in Jenkins?**  
    *A:* In the `post { failure {} }` block, trigger an automated rollback script that copies back the backup directory of the previously working release, or re-run a previous successful Jenkins build.
20. **Q: What is GitOps in modern web deployment?**  
    *A:* An operational framework where Git is the single source of truth for both application code and deployment state, where an automated agent continuously reconciles the live cluster/server state with Git.

### Practical Scenario-Based Questions (5)
21. **Scenario:** *A developer pushes a CSS change that breaks layout on mobile devices. How does a mature web CI/CD pipeline prevent this from reaching production?*  
    *Answer:* Integrate visual regression testing tools (like Percy or Cypress) into the Jenkins Test stage. Automated headless browser screenshots are compared pixel-by-pixel against baseline screenshots. If unexpected visual shifts occur, the build fails before deployment.
22. **Scenario:** *During deployment, copying 5,000 individual files to `/var/www/html` takes 20 seconds, causing temporary 404 errors for active users while files are mid-copy. How do you achieve zero-downtime atomic deployment?*  
    *Answer:* Deploy to a new timestamped release folder (e.g., `/var/www/releases/20261117_120000`). Once all files are fully copied, update a symlink atomically: `ln -sfn /var/www/releases/20261117_120000 /var/www/html`. Linux symlink switching occurs instantaneously in a single OS filesystem operation.
23. **Scenario:** *A junior developer accidentally commits hardcoded API backend URLs (`http://localhost:3000`) into frontend JavaScript, breaking production. How can CI catch this?*  
    *Answer:* Add a linter or regex scan step in the Test stage of the `Jenkinsfile`: `grep -rn "http://localhost" src/ && { echo "Hardcoded localhost detected!"; exit 1; }`. Alternatively, use environment variable injection during the build stage.
24. **Scenario:** *A web pipeline succeeds in copying files, but users report a blank white screen because an import statement in JavaScript has a typo. What pipeline stage was missing?*  
    *Answer:* An automated end-to-end (E2E) smoke test stage was missing. The pipeline should have launched a headless browser (Puppeteer or Playwright) against the deployed test URL to verify that the DOM renders `#main-heading` and zero unhandled JavaScript console errors occur before marking the build as successful.
25. **Scenario:** *You want to preview changes on a unique staging URL for every open Pull Request before merging to `main`. How can Jenkins achieve this?*  
    *Answer:* Use a Jenkins Multibranch Pipeline. When a PR is opened, Jenkins builds the PR branch, deploys the web files into a preview folder named after the PR number (`/var/www/html/pr-${env.CHANGE_ID}`), and posts the preview link as an automated comment on the GitHub PR.

---

## 7. Real-World Applications
* **E-Commerce Platforms:** Retail sites update product banners, promotional pricing, and checkout styles multiple times a day through automated web CI/CD pipelines without downtime.
* **Content Management & Documentation Sites:** Technical documentation (like GitHub Docs, Stripe Docs) deploys markdown updates automatically to global CDNs upon PR approval.

---

# Experiment 7: Introduction to Containerization and Application Deployment using Docker

## 1. Experiment Overview
* **Experiment Number:** 07
* **Title:** Introduction to Containerization and Application Deployment using Docker
* **Course Outcome:** CO4 – Create, manage, and deploy containerized applications using Docker.
* **Aim:** To understand the concepts and architectural advantages of containerization over traditional virtualization, master core Docker components (Engine, Images, Containers, Dockerfile, Registries), build and deploy a containerized Python Flask web application, and fulfill the lab manual problem statement by containerizing and deploying a Java application.
* **Objectives:**
  1. To differentiate between Virtual Machines (Hardware Virtualization) and Containers (OS-level Virtualization).
  2. To install, configure, and verify Docker Desktop on macOS.
  3. To write an efficient `Dockerfile` following best practices (layer caching, workdir, slim base images).
  4. To build Docker images, inspect image metadata, and run isolated background containers with host port mapping.
  5. To inspect container lifecycle states, read stdout/stderr logs, execute commands inside running containers, and clean up resources.
  6. To containerize and deploy a Java application as specified in the lab problem statement.
* **Tools and Technologies Required:** macOS Terminal, Docker Desktop for Mac (Apple Silicon / Intel), Python 3, OpenJDK 17, Web Browser, VS Code.
* **Prerequisites:** Basic command line navigation and understanding of client-server networking (ports and localhost).

---

## 2. Concepts & Theoretical Background

### 2.1 Virtual Machines vs. Containers
* **Virtual Machine (VM):** Each VM bundles a full Guest Operating System (GBs in size), virtualized virtual hardware (Hypervisor Type 1 or Type 2), binaries, libraries, and application code. VMs take minutes to boot, consume significant CPU and RAM, and have heavy storage footprints.
* **Container:** Containers share the host operating system kernel and isolate applications using Linux Kernel features: **Namespaces** (process isolation: PID, NET, IPC, MNT, UTS) and **Control Groups (cgroups)** (resource limits: CPU, Memory, Disk I/O). Containers start in milliseconds, consume mere megabytes of RAM, and achieve near bare-metal performance.

```
+----------------------------------------+   +----------------------------------------+
|          VIRTUAL MACHINES (VMs)        |   |           DOCKER CONTAINERS            |
|                                        |   |                                        |
|  +--------------+    +--------------+  |   |  +--------------+    +--------------+  |
|  |    App A     |    |    App B     |  |   |  |    App A     |    |    App B     |  |
|  +--------------+    +--------------+  |   |  +--------------+    +--------------+  |
|  | Bins / Libs  |    | Bins / Libs  |  |   |  | Bins / Libs  |    | Bins / Libs  |  |
|  +--------------+    +--------------+  |   |  +--------------+    +--------------+  |
|  |   Guest OS   |    |   Guest OS   |  |   |  |     DOCKER CONTAINER ENGINE     |  |
|  +--------------+    +--------------+  |   +----------------------------------------+
|  |         HYPERVISOR (ESXi/VBox)   |  |   |         HOST OPERATING SYSTEM          |
|  +-------------------------------------+   |        (macOS / Linux / Windows)       |
|  |         HOST HARDWARE (CPU/RAM)     |   |         HOST HARDWARE (CPU/RAM)        |
+----------------------------------------+   +----------------------------------------+
```

### 2.2 Core Docker Architecture
1. **Docker Engine (Daemon - `dockerd`):** The background service managing containers, images, networks, and storage volumes.
2. **Docker Client (`docker` CLI):** The command-line interface developers interact with to issue commands to the daemon via Unix sockets or REST API.
3. **Docker Image:** An immutable, read-only template built from layered filesystems representing an application snapshot.
4. **Docker Container:** A runnable, isolated instance of a Docker image with an added thin, read-write container layer on top.
5. **Dockerfile:** A plain-text configuration script containing consecutive instructions executed in order to build an image.
6. **Docker Hub:** A cloud-based public and private container registry to store, share, and distribute container images worldwide.

---

## 3. Complete Implementation: Containerizing Flask and Java Applications

### Directory Context
Open macOS Terminal. Navigate to your workspace directory (e.g., `~/Desktop/devops-lab`):

```bash
cd ~/Desktop/devops-lab
```

### Step 1: Verify Docker Installation on macOS
Check that Docker Desktop is running and responsive:

```bash
docker --version
docker info
```
* **Expected Output:**
  ```text
  Docker version 27.x.x (or 29.x.x), build ...
  Server:
   Containers: 1
   Running: 1
   Paused: 0
   Stopped: 0
   Images: 4
   Server Version: 27.x.x
  ```

### Step 2: Implement Flask Web Application
Create the project folder and the application files as outlined in the laboratory manual:

```bash
mkdir flask-docker-app
cd flask-docker-app

# 1. Create app.py
cat << 'EOF' > app.py
from flask import Flask

app = Flask(__name__)

@app.route('/')
def home():
    return "Hello, Docker! 🚀 - Containerized Flask Application Running Successfully!"

@app.route('/health')
def health():
    return {"status": "UP", "container": "flask-docker-app"}

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)
EOF

# 2. Create requirements.txt
cat << 'EOF' > requirements.txt
flask==2.3.2
EOF
```
* **Explanation:**
  * `host='0.0.0.0'`: Crucial for containerized applications. Binds the server to all network interfaces inside the container, allowing external traffic mapped through Docker ports to reach the app.

### Step 3: Write the Dockerfile for Flask
Create the container blueprint:

```bash
cat << 'EOF' > Dockerfile
# Use official minimal Python base image
FROM python:3.9-slim

# Set working directory inside container
WORKDIR /app

# Copy dependency definition first for optimal layer caching
COPY requirements.txt requirements.txt

# Install dependencies
RUN pip install --no-cache-dir -r requirements.txt

# Copy application source code
COPY . .

# Expose container port
EXPOSE 5000

# Specify command to execute when container launches
CMD ["python", "app.py"]
EOF
```
* **Line-by-Line Explanation:**
  * `FROM python:3.9-slim`: Starts from a lightweight Debian Linux base image with Python 3.9 pre-installed (reduces attack surface and image size from ~1GB to ~120MB).
  * `WORKDIR /app`: Creates and sets `/app` as the execution directory for all subsequent instructions.
  * `COPY requirements.txt requirements.txt`: Copies dependencies file first. If source code changes but dependencies do not, Docker reuses cached layers up to this step, accelerating rebuilds.
  * `RUN pip install ...`: Executes package installation inside the image filesystem layer during build time.
  * `COPY . .`: Copies the remaining project files into `/app`.
  * `EXPOSE 5000`: Documents that the container process listens on TCP port 5000.
  * `CMD ["python", "app.py"]`: Specifies the default executable command run when the container starts.

### Step 4: Build the Docker Image
Execute the build command in the folder containing the `Dockerfile`:

```bash
# Build image tagged flask-docker-app:1.0
docker build -t flask-docker-app:1.0 .

# Verify image in local registry
docker images | grep flask-docker-app
```
* **Explanation:**
  * `docker build`: Command to assemble an image from a `Dockerfile`.
  * `-t flask-docker-app:1.0`: Assigns a name (`flask-docker-app`) and tag version (`1.0`).
  * `.`: Specifies the **build context** (the current directory sent to the Docker daemon).
* **Expected Output:**
  ```text
  [+] Building 4.2s (10/10) FINISHED
   => [internal] load build definition from Dockerfile
   => [1/4] FROM docker.io/library/python:3.9-slim
   => [2/4] WORKDIR /app
   => [3/4] COPY requirements.txt requirements.txt
   => [4/4] RUN pip install --no-cache-dir -r requirements.txt
   => exporting to image
   => naming to docker.io/library/flask-docker-app:1.0
  REPOSITORY          TAG       IMAGE ID       CREATED          SIZE
  flask-docker-app    1.0       a4b8c9d1e2f3   10 seconds ago   135MB
  ```

### Step 5: Run the Docker Container
Start a container instance from the image:

```bash
# Run container in background with port mapping
docker run -d -p 5000:5000 --name my-flask-app flask-docker-app:1.0

# Verify active running container
docker ps
```
* **Explanation:**
  * `-d`: Detached mode (runs container in background, frees terminal).
  * `-p 5000:5000`: Port forwarding: Maps `<host_port>:<container_port>`. Requests sent to `http://localhost:5000` on macOS are routed to port 5000 inside the container.
  * `--name my-flask-app`: Assigns a human-friendly name to the container instead of a random UUID.
* **Expected Output:**
  ```text
  CONTAINER ID   IMAGE                  COMMAND             CREATED         STATUS         PORTS                    NAMES
  7f2e1a4b9c8d   flask-docker-app:1.0   "python app.py"     3 seconds ago   Up 2 seconds   0.0.0.0:5000->5000/tcp   my-flask-app
  ```

### Step 6: Access and Test the Application
Test the endpoint via Terminal or open your web browser to `http://localhost:5000`:

```bash
curl http://localhost:5000
curl http://localhost:5000/health
```
* **Expected Output:**
  ```text
  Hello, Docker! 🚀 - Containerized Flask Application Running Successfully!
  {"container":"flask-docker-app","status":"UP"}
  ```

### Step 7: View Container Logs and Execute Interactive Commands
```bash
# Inspect container standard output logs
docker logs my-flask-app

# Execute an interactive bash/sh shell inside the running container
docker exec -it my-flask-app sh -c "uname -a && python --version && ls -la /app"
```
* **Explanation:**
  * `docker logs`: Prints all messages written to stdout/stderr by the containerized app.
  * `docker exec -it <name> <cmd>`: Runs a command inside a live container without restarting it (`-i` interactive, `-t` allocate pseudo-TTY).

### Step 8: Problem Statement Implementation – Deploy Java Application using Docker
As required by the Problem Statement in Experiment 7, create and deploy a containerized Java application:

```bash
cd ~/Desktop/devops-lab
mkdir java-docker-app
cd java-docker-app

# Create Java application
cat << 'EOF' > Main.java
public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("  Java Application Running Inside Docker Container ");
        System.out.println("  Java Version: " + System.getProperty("java.version"));
        System.out.println("  Container Deployment Verified Successfully!      ");
        System.out.println("==================================================");
    }
}
EOF

# Create multi-stage Java Dockerfile
cat << 'EOF' > Dockerfile
# Stage 1: Build Java application
FROM openjdk:17-jdk-slim AS builder
WORKDIR /app
COPY Main.java .
RUN javac Main.java

# Stage 2: Minimal runtime image
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/Main.class .
CMD ["java", "Main"]
EOF

# Build and run Java container
docker build -t java-docker-app:1.0 .
docker run --rm java-docker-app:1.0
```
* **Expected Output:**
  ```text
  ==================================================
    Java Application Running Inside Docker Container 
    Java Version: 17.0.x
    Container Deployment Verified Successfully!      
  ==================================================
  ```

### Step 9: Container Lifecycle Cleanup
Stop and remove containers and free disk space:

```bash
# Stop running container
docker stop my-flask-app

# Remove container
docker rm my-flask-app

# Remove Docker image
docker rmi flask-docker-app:1.0 java-docker-app:1.0
```

---

## 4. Important Commands Reference

| Command | Purpose | Explanation |
| :--- | :--- | :--- |
| `docker build -t <name:tag> .` | Build Docker image | Compiles Dockerfile instructions into layered immutable image using current context `.`. |
| `docker run -d -p <H:C> <img>` | Run detached container | Instantiates image into running background container with host-to-container port mapping. |
| `docker ps` | List active containers | Displays running containers with container IDs, image tags, status, and port bindings. |
| `docker ps -a` | List all containers | Displays all containers including stopped, exited, and failed containers. |
| `docker images` | List local images | Lists all Docker images stored in local registry with size and creation dates. |
| `docker logs -f <name>` | Follow container logs | Streams console output (stdout/stderr) from container in real time for debugging. |
| `docker exec -it <name> sh` | Open shell in container | Spawns an interactive shell inside a running container for direct file inspection. |
| `docker stop <name>` | Stop running container | Sends SIGTERM followed by SIGKILL to gracefully shut down containerized processes. |
| `docker rm <name>` | Remove stopped container | Deletes the container's writable layer and metadata from disk. |
| `docker rmi <image_id>` | Remove Docker image | Deletes local cached image layers from disk (fails if containers currently use it). |

---

## 5. Troubleshooting Common Docker Errors

1. **Error:** `Bind for 0.0.0.0:5000 failed: port is already allocated`
   * **Reason:** Another service on macOS (or another running container) is already bound to port 5000 (AirPlay Receiver often uses port 5000 on macOS Monterey/Ventura/Sonoma).
   * **Solution:** Map to a different host port (e.g., `-p 5001:5000`), or disable AirPlay Receiver in macOS System Settings -> General -> AirDrop & AirPlay.
2. **Error:** `standard_init_linux.go: exec user process caused: no such file or directory`
   * **Reason:** Windows CRLF line endings in scripts (`\r\n`) executed inside a Linux container, or an invalid path in `CMD` / `ENTRYPOINT`.
   * **Solution:** Convert line endings to Unix LF (`\n`) using `dos2unix` or VS Code bottom-right status bar.
3. **Error:** Container exits immediately with `Exited (0)` or `Exited (1)`
   * **Reason:** The foreground process specified in `CMD` completed its execution or crashed. Docker containers only run as long as their primary foreground PID 1 process is alive.
   * **Solution:** Run `docker logs <container_id>` to view crash trace, or ensure server processes run in the foreground (e.g., `nginx -g 'daemon off;'`).

---

## 6. Viva and Interview Questions

### Basic Questions (10)
1. **Q: What is Docker?**  
   *A:* An open-source platform that enables developers to package, ship, and run applications inside lightweight, portable, self-sufficient environments called containers.
2. **Q: What is the difference between a Docker Image and a Docker Container?**  
   *A:* A Docker Image is an immutable, read-only template containing application code, libraries, and runtime dependencies. A Container is a running, stateful instance of an image with a thin read-write layer added on top.
3. **Q: What is a Dockerfile?**  
   *A:* A plain-text text file containing ordered instructions (`FROM`, `WORKDIR`, `COPY`, `RUN`, `CMD`) that Docker executes automatically to assemble a container image.
4. **Q: What is Docker Hub?**  
   *A:* A public cloud-based registry service hosted by Docker used to share, store, and distribute official and community container images.
5. **Q: What is the difference between `RUN`, `CMD`, and `ENTRYPOINT` in a Dockerfile?**  
   *A:* `RUN` executes during image build time to commit new image layers (e.g., installing packages). `CMD` provides default arguments for container runtime that can be overridden from the CLI. `ENTRYPOINT` defines the fixed executable binary that runs when the container starts.
6. **Q: What is the difference between Virtual Machines and Containers?**  
   *A:* VMs virtualize the underlying physical hardware and run full separate Guest OS instances. Containers virtualize the operating system kernel and run isolated processes directly on the host kernel.
7. **Q: What are Linux Namespaces in Docker?**  
   *A:* A Linux kernel technology that provides isolated workspace boundaries for containers: Process IDs (PID), Network interfaces (NET), Mount points (MNT), and Inter-process communication (IPC).
8. **Q: What are Control Groups (cgroups) in Docker?**  
   *A:* A Linux kernel mechanism that meters, limits, and allocates hardware resource consumption (CPU, RAM, disk I/O, network bandwidth) for container processes.
9. **Q: What does port mapping `-p 8080:80` mean?**  
   *A:* It maps port 8080 on the host machine to port 80 inside the container, directing incoming host network traffic into the containerized web server.
10. **Q: What does the `--rm` flag in `docker run --rm` do?**  
    *A:* Automatically removes the container and its writeable filesystem layer when the container exits, preventing container clutter on disk.

### Intermediate Questions (10)
11. **Q: What is Docker Layer Caching and how do you optimize it?**  
    *A:* Each instruction in a Dockerfile creates a read-only layer. Docker caches unchanged layers. To optimize caching, place rarely changing instructions (e.g., OS base image, dependency manifests `pom.xml`, `requirements.txt`) at the top, and frequently changing application source code at the bottom.
12. **Q: What is a Multi-Stage Docker Build and why is it used?**  
    *A:* A technique where a Dockerfile uses multiple `FROM` instructions. Early heavy stages compile code using large SDKs (e.g., Maven, JDK), while the final lightweight stage copies only the built binary into a minimal runtime image (e.g., JRE), drastically shrinking image size and eliminating compiler tools from production.
13. **Q: What is the difference between a Bind Mount and a Named Volume in Docker?**  
    *A:* A Bind Mount maps a specific directory from the host filesystem directly into the container (path-dependent). A Named Volume is managed completely by Docker inside Docker storage directories (`/var/lib/docker/volumes/`), providing cross-platform portability and better performance.
14. **Q: What happens to data stored inside a container when the container is deleted without a volume?**  
    *A:* All data written to the container's thin read-write layer is permanently destroyed and cannot be recovered.
15. **Q: What are the primary Docker network drivers?**  
    *A:* **bridge** (default isolated network on a single host), **host** (shares host network stack, no isolation), **overlay** (enables communication across multi-host Swarm or Kubernetes clusters), and **none** (completely disables networking).
16. **Q: Why should you avoid running containers as the `root` user?**  
    *A:* Security defense in depth: If an attacker escapes a container running as root, they gain root privileges on the host operating system. Using `USER appuser` minimizes container breakout vulnerabilities.
17. **Q: What is the `.dockerignore` file?**  
    *A:* A text file specifying patterns of files and directories (like `.git/`, `node_modules/`, `target/`, `.DS_Store`) to exclude from the build context sent to the Docker daemon, speeding up builds and reducing image sizes.
18. **Q: How can you limit memory and CPU on a container?**  
    *A:* Using resource flags: `docker run -m 512m --cpus=1.5 ...`.
19. **Q: What is the purpose of Docker Content Trust (DCT)?**  
    *A:* A security system that uses digital signatures to verify the integrity and publisher authenticity of images pulled from registries.
20. **Q: What is the difference between `docker pause` and `docker stop`?**  
    *A:* `docker pause` suspends all container processes using the `cgroup freezer` without terminating memory state. `docker stop` sends a `SIGTERM` followed by `SIGKILL` to cleanly terminate processes and release memory.

### Practical Scenario-Based Questions (5)
21. **Scenario:** *A Python application Docker image is 1.2 GB in size. The deployment to remote servers takes 10 minutes over the network. How do you reduce the image size?*  
    *Answer:* Switch base image from full `python:3.9` to `python:3.9-slim` or `python:3.9-alpine`. Combine `RUN` commands to minimize layer count. Use multi-stage builds. Add `.dockerignore` to exclude test files and git history. Clear pip cache with `--no-cache-dir`. This typically reduces image size from 1.2 GB to under 100 MB.
22. **Scenario:** *A developer runs `docker run -d -p 8080:8080 my-app`, but when they test `curl http://localhost:8080`, it returns `curl: (52) Empty reply from server`. What is the issue?*  
    *Answer:* The application inside the container is listening on `127.0.0.1` (localhost) instead of `0.0.0.0`. Inside a container, `127.0.0.1` refers only to the container's internal loopback adapter. The app must bind to `0.0.0.0` to receive traffic forwarded from the host port mapping.
23. **Scenario:** *A PostgreSQL database container is deleted and recreated during an upgrade, and all database tables are missing. Why did this happen and how do you prevent it?*  
    *Answer:* The database files were stored inside the container's ephemeral writable layer instead of a persistent Docker volume. To prevent data loss, always mount a Docker named volume: `-v pgdata:/var/lib/postgresql/data`.
24. **Scenario:** *Two microservices running in separate containers on the same Docker host cannot communicate with each other using container names. Why?*  
    *Answer:* The default `bridge` network does not provide automatic DNS container name resolution. You must create a user-defined custom bridge network (`docker network create my-net`) and attach both containers (`--network my-net`). Custom bridge networks provide automatic container name DNS resolution.
25. **Scenario:** *A containerized node.js application crashes periodically due to memory leaks. How can you configure Docker to keep the service available?*  
    *Answer:* Use the restart policy flag: `--restart=always` or `--restart=on-failure:5`. Docker daemon will automatically detect the exit and restart the container within seconds.

---

## 7. Real-World Applications
* **Microservices Architecture:** Companies like Uber and Twitter split monolithic backends into hundreds of microservices, each packaged into isolated Docker containers with independent scaling and deployment.
* **Environment Parity:** Eliminates the infamous "It works on my machine!" excuse across thousands of developer laptops running macOS, Windows, and Linux.

---

# Experiment 8: Building a CI/CD Pipeline using Docker and Jenkins

## 1. Experiment Overview
* **Experiment Number:** 08
* **Title:** Building a CI/CD Pipeline using Docker and Jenkins
* **Course Outcome:** CO4 – Create, manage, and deploy containerized applications using Docker.
* **Aim:** To design and implement a complete enterprise CI/CD automation pipeline integrating Jenkins and Docker that automatically pulls code upon GitHub push, compiles and tests code, builds an immutable Docker image tagged with build numbers, pushes the image to Docker Hub container registry using credentials, and deploys the containerized application.
* **Objectives:**
  1. To understand how Jenkins and Docker work synergistically in modern cloud-native CI/CD pipelines.
  2. To configure Jenkins with Docker-outside-of-Docker (DooD) execution capabilities via Docker socket mounting (`/var/run/docker.sock`).
  3. To configure secure Docker Hub registry credentials inside Jenkins Credential Store.
  4. To author a production-grade Declarative `Jenkinsfile` orchestrating: Git Checkout, Unit Testing, Docker Image Assembly, Registry Push, and Container Deployment.
  5. To verify continuous deployment by pushing updates to GitHub and watching the newly tagged image publish to Docker Hub.
* **Tools and Technologies Required:** macOS Terminal, Docker Desktop, Jenkins Container, Docker Hub Account, Git, GitHub.
* **Prerequisites:** Completion of Experiment 5 (Jenkins jobs) and Experiment 7 (Docker fundamentals).

---

## 2. Concepts & Theoretical Background

### 2.1 Why Combine Jenkins and Docker?
Traditional CI/CD servers suffered from "Dependency Hell": Jenkins worker agents required every compiler, JDK, Python, Node, and database version manually installed on the host OS. When projects required conflicting library versions, builds collided.

By integrating Docker into Jenkins:
* **Disposable Build Environments:** Jenkins spins up isolated Docker containers for individual build steps and discards them afterward.
* **Immutable Artifacts:** Instead of distributing raw `.jar` or `.war` files that require manual server configuration, the pipeline produces a Docker container image that encapsulates the exact runtime, configuration, and dependencies verified during testing.

```
+-----------------------------------------------------------------------------------------------+
|                            JENKINS + DOCKER CI/CD WORKFLOW                                    |
|                                                                                               |
|  [ Developer ] -- git push -> [ GitHub Repo ]                                                 |
|                                     |                                                         |
|                             Webhook / SCM Trigger                                             |
|                                     v                                                         |
|                           [ Jenkins Pipeline ]                                                |
|                                     |                                                         |
|     +-------------------------------+-------------------------------+                         |
|     |                               |                               |                         |
|     v                               v                               v                         |
|  [ Stage 1: Checkout ]      [ Stage 2: Test ]         [ Stage 3: Docker Build ]               |
|  Clones source code         Runs JUnit / PyTest       docker build -t user/app:42             |
|                                                                     |                         |
|                                                                     v                         |
|                                                           [ Stage 4: Docker Push ]            |
|                                                           Pushes to Docker Hub Registry       |
|                                                                     |                         |
|                                                                     v                         |
|                                                           [ Stage 5: Deploy ]                 |
|                                                           Runs container on Target Server     |
+-----------------------------------------------------------------------------------------------+
```

### 2.2 Docker-outside-of-Docker (DooD) via Docker Socket Mount
To allow Jenkins (which is running inside a Docker container) to execute Docker build commands, we mount the host machine's Docker Unix socket into the Jenkins container:
`-v /var/run/docker.sock:/var/run/docker.sock`

This enables the Jenkins container to command the host's Docker daemon directly, building images and launching sibling containers natively on the host Mac.

---

## 3. Complete Implementation: Jenkins & Docker Pipeline

### Directory Context
Open macOS Terminal. Navigate to your workspace directory (e.g., `~/Desktop/devops-lab`):

```bash
cd ~/Desktop/devops-lab
```

### Step 1: Set Up Jenkins Container with Docker Capabilities
Launch Jenkins with the Docker socket and volume mounted:

```bash
# Stop any existing Jenkins container
docker stop jenkins 2>/dev/null || true
docker rm jenkins 2>/dev/null || true

# Launch Jenkins LTS with Docker socket integration
docker run -d \
  --name jenkins \
  -p 8080:8080 \
  -p 50000:50000 \
  -v jenkins_home:/var/jenkins_home \
  -v /var/run/docker.sock:/var/run/docker.sock \
  --user root \
  --restart=unless-stopped \
  jenkins/jenkins:lts
```
* **Explanation:**
  * `-v /var/run/docker.sock:/var/run/docker.sock`: Mounts the host Docker socket into Jenkins.
  * `--user root`: Grants Jenkins container root permissions to access the Docker socket file permissions.

Install the Docker CLI binary inside the Jenkins container:

```bash
docker exec -it jenkins sh -c "curl -fsSL https://get.docker.com | sh"

# Verify Docker works from inside Jenkins
docker exec -it jenkins docker --version
```
* **Expected Output:**
  ```text
  Docker version 27.x.x, build ...
  ```

### Step 2: Install Required Plugins in Jenkins UI
1. Open Jenkins: `http://localhost:8080`.
2. Go to **Manage Jenkins** -> **Plugins** -> **Available Plugins**.
3. Search and install:
   * **Docker Pipeline**
   * **Docker plugin**
   * **Pipeline**
   * **Git plugin**
4. Check **Restart Jenkins when installation is complete and no jobs are running**.

### Step 3: Configure Docker Hub Credentials in Jenkins
To securely push images to Docker Hub without hardcoding passwords in scripts:
1. In Jenkins, go to **Manage Jenkins** -> **Credentials** -> **System** -> **Global credentials (unrestricted)**.
2. Click **Add Credentials**:
   * **Kind:** Username with password
   * **Scope:** Global
   * **Username:** Enter your Docker Hub username (e.g., `atharvpatil`)
   * **Password:** Enter your Docker Hub Password or Personal Access Token (PAT)
   * **ID:** `dockerhub-credentials-id` (Exact ID matching the lab manual Jenkinsfile!)
   * **Description:** `Docker Hub Registry Credentials`
3. Click **Create**.

### Step 4: Create Application with Dockerfile and Jenkinsfile
Create an application repository named `DevOps-Docker-Jenkins-Pipeline`:

```bash
mkdir -p ~/Desktop/devops-lab/DevOps-Docker-Jenkins-Pipeline
cd ~/Desktop/devops-lab/DevOps-Docker-Jenkins-Pipeline
git init

# 1. Create simple app: server.py
cat << 'EOF' > server.py
from http.server import SimpleHTTPRequestHandler, HTTPServer
import os

PORT = int(os.environ.get("PORT", 8080))

class CustomHandler(SimpleHTTPRequestHandler):
    def do_GET(self):
        self.send_response(200)
        self.send_header("Content-type", "text/html")
        self.end_headers()
        html = f"""
        <html>
        <body style='font-family:sans-serif; text-align:center; padding:50px;'>
            <h1 style='color:#0366d6;'>DevOps Automated Pipeline LIVE</h1>
            <p>Built with <b>Jenkins</b> & Containerized with <b>Docker</b></p>
            <p>Build Status: Verified Active</p>
        </body>
        </html>
        """
        self.wfile.write(html.encode("utf-8"))

if __name__ == "__main__":
    print(f"Server starting on port {PORT}...")
    server = HTTPServer(("0.0.0.0", PORT), CustomHandler)
    server.serve_forever()
EOF

# 2. Create Dockerfile
cat << 'EOF' > Dockerfile
FROM python:3.9-alpine
WORKDIR /app
COPY server.py .
EXPOSE 8080
ENV PORT=8080
CMD ["python", "server.py"]
EOF
```

### Step 5: Write the Complete CI/CD `Jenkinsfile`
Author the complete `Jenkinsfile` matching the lab manual requirements:

```groovy
pipeline {
    agent any

    environment {
        // Replace with your actual Docker Hub username
        DOCKER_HUB_USER      = 'atharvpatil'
        APP_NAME             = 'devops-demo-service'
        DOCKER_IMAGE         = "${DOCKER_HUB_USER}/${APP_NAME}"
        REGISTRY_CREDENTIALS = 'dockerhub-credentials-id'
    }

    stages {
        // ----------------------------------------------------------------------
        // STAGE 1: Code Checkout
        // ----------------------------------------------------------------------
        stage('Checkout') {
            steps {
                echo '========== STAGE 1: Checking out source code =========='
                checkout scm
                sh 'git log -1 --oneline'
            }
        }

        // ----------------------------------------------------------------------
        // STAGE 2: Automated Testing
        // ----------------------------------------------------------------------
        stage('Automated Test') {
            steps {
                echo '========== STAGE 2: Running automated sanity tests =========='
                sh '''
                    python3 -m py_compile server.py
                    echo "Python syntax validation passed successfully."
                '''
            }
        }

        // ----------------------------------------------------------------------
        // STAGE 3: Build Docker Image
        // ----------------------------------------------------------------------
        stage('Build Docker Image') {
            steps {
                echo "========== STAGE 3: Building Docker Image: ${DOCKER_IMAGE}:${env.BUILD_NUMBER} =========="
                sh """
                    docker build -t ${DOCKER_IMAGE}:${env.BUILD_NUMBER} -t ${DOCKER_IMAGE}:latest .
                    docker images | grep ${APP_NAME}
                """
            }
        }

        // ----------------------------------------------------------------------
        // STAGE 4: Push to Docker Hub
        // ----------------------------------------------------------------------
        stage('Push to Docker Hub') {
            steps {
                echo "========== STAGE 4: Pushing Docker Image to Registry =========="
                withCredentials([usernamePassword(credentialsId: "${REGISTRY_CREDENTIALS}", usernameVariable: 'DH_USER', passwordVariable: 'DH_PASS')]) {
                    sh """
                        echo \$DH_PASS | docker login -u \$DH_USER --password-stdin
                        docker push ${DOCKER_IMAGE}:${env.BUILD_NUMBER}
                        docker push ${DOCKER_IMAGE}:latest
                    """
                }
            }
        }

        // ----------------------------------------------------------------------
        // STAGE 5: Deploy Application
        // ----------------------------------------------------------------------
        stage('Deploy') {
            steps {
                echo "========== STAGE 5: Deploying latest containerized image =========="
                sh """
                    # Stop and remove older version of container if running
                    docker stop ${APP_NAME}-prod 2>/dev/null || true
                    docker rm ${APP_NAME}-prod 2>/dev/null || true
                    
                    # Run newly built image on port 9090
                    docker run -d -p 9090:8080 --name ${APP_NAME}-prod ${DOCKER_IMAGE}:${env.BUILD_NUMBER}
                    
                    # Verify running status
                    docker ps | grep ${APP_NAME}-prod
                """
            }
        }
    }

    // --------------------------------------------------------------------------
    // Post-Pipeline Actions
    // --------------------------------------------------------------------------
    post {
        success {
            echo "SUCCESS: Pipeline completed! Visit application at: http://localhost:9090"
        }
        failure {
            echo "FAILURE: Pipeline execution failed! Inspect console output for troubleshooting."
        }
    }
}
```

### Step 6: Push Code to GitHub and Run Pipeline
```bash
git branch -M main
git add .
git commit -m "feat: complete dockerized app with end-to-end CI/CD Jenkinsfile"
git remote add origin https://github.com/your-username/DevOps-Docker-Jenkins-Pipeline.git
git push -u origin main
```
1. In Jenkins: **New Item** -> Name: `Docker-CI-CD-Pipeline` -> Select **Pipeline** -> Click **OK**.
2. Under **Pipeline**:
   * Definition: **Pipeline script from SCM**
   * SCM: **Git**
   * Repository URL: `https://github.com/your-username/DevOps-Docker-Jenkins-Pipeline.git`
   * Branch: `*/main`
   * Script Path: `Jenkinsfile`
3. Click **Save** -> Click **Build Now**.
4. Monitor the build logs. Watch Jenkins:
   * Compile and test `server.py`
   * Build the Docker image tagged with build `#1`
   * Log in to Docker Hub and push the image
   * Launch the deployed container `${APP_NAME}-prod`
5. Test live deployment:
   ```bash
   curl http://localhost:9090
   ```
   * **Expected Output:**
     ```html
     <html>
     <body style='font-family:sans-serif; text-align:center; padding:50px;'>
         <h1 style='color:#0366d6;'>DevOps Automated Pipeline LIVE</h1>
         <p>Built with <b>Jenkins</b> & Containerized with <b>Docker</b></p>
         <p>Build Status: Verified Active</p>
     </body>
     </html>
     ```

---

## 4. Important Commands Reference

| Command | Purpose | Explanation |
| :--- | :--- | :--- |
| `-v /var/run/docker.sock:...` | Mount Docker socket | Exposes host Docker daemon to Jenkins container to allow DooD builds. |
| `withCredentials([...])` | Inject credentials | Safely passes encrypted Docker Hub secrets as environment variables inside pipeline steps. |
| `docker login --password-stdin` | Secure Docker login | Authenticates with container registry securely without exposing credentials in bash history. |
| `docker push <user/repo:tag>` | Push image to registry | Uploads local container layers to remote registry (Docker Hub / AWS ECR). |
| `docker ps \| grep <name>` | Verify container deployment | Filters process list to confirm the newly deployed service container is active. |

---

## 5. Troubleshooting Common Pipeline Errors

1. **Error:** `docker: command not found` inside Jenkins Pipeline
   * **Reason:** The Docker client binary is not installed inside the Jenkins container.
   * **Solution:** Install the Docker CLI in the container: `docker exec -it -u 0 jenkins apt-get update && docker exec -it -u 0 jenkins apt-get install -y docker.io`.
2. **Error:** `Got permission denied while trying to connect to the Docker daemon socket`
   * **Reason:** The user executing the Jenkins job does not have write permissions to `/var/run/docker.sock`.
   * **Solution:** On the host terminal, run `docker exec -u 0 jenkins chmod 666 /var/run/docker.sock`, or ensure Jenkins container runs as root.
3. **Error:** `denied: requested access to the resource is denied` during `docker push`
   * **Reason:** Docker Hub authentication failed or repository image name does not match the authenticated Docker Hub username.
   * **Solution:** Verify `DOCKER_HUB_USER` in `Jenkinsfile` matches your exact Docker Hub username, and verify your password/token in Jenkins credentials.

---

## 6. Viva and Interview Questions

### Basic Questions (10)
1. **Q: Why are Docker and Jenkins used together in CI/CD?**  
   *A:* Jenkins orchestrates the workflow (triggers, testing, scheduling), while Docker provides clean, isolated, reproducible environments for building and deploying applications.
2. **Q: What is a Container Registry?**  
   *A:* A centralized repository service used to store, manage, and distribute container images (e.g., Docker Hub, AWS ECR, Google Artifact Registry).
3. **Q: What is the purpose of image tagging in CI/CD?**  
   *A:* To provide unique version traceability. Tagging images with `${env.BUILD_NUMBER}` or Git commit SHA ensures every deployment can be precisely traced back to the exact code commit that produced it.
4. **Q: What does mounting `/var/run/docker.sock` achieve in Jenkins?**  
   *A:* It enables "Docker-outside-of-Docker" (DooD), allowing a Jenkins container to build and run sibling containers on the host's Docker engine.
5. **Q: How does Jenkins securely authenticate with Docker Hub?**  
   *A:* Using the Jenkins Credentials Store and the `withCredentials` pipeline step to inject secrets dynamically without printing them in plain text console logs.
6. **Q: What is the difference between `latest` tag and a versioned tag?**  
   *A:* `latest` is a mutable pointer to the most recently pushed image. A versioned tag (e.g., `1.0.4` or `build-42`) is immutable, ensuring reproducible, deterministic deployments.
7. **Q: What is Docker-in-Docker (DinD) vs. Docker-outside-of-Docker (DooD)?**  
   *A:* DinD runs a complete nested Docker daemon inside a container (requires privileged security mode). DooD shares the host's Docker daemon via socket mounting, which is simpler and more efficient.
8. **Q: What is a Quality Gate in a CI/CD pipeline?**  
   *A:* A checklist of conditions (e.g., 0 failing tests, 80% code coverage, 0 critical security bugs) that must pass before an artifact is permitted to progress to the deployment stage.
9. **Q: What happens if the `Automated Test` stage fails in the pipeline?**  
   *A:* The pipeline halts immediately. The Docker image is neither built nor pushed to Docker Hub, protecting production from buggy releases.
10. **Q: What command is used to log in to Docker Hub via CLI non-interactively?**  
    *A:* `echo $PASSWORD | docker login -u $USERNAME --password-stdin`.

### Intermediate Questions (10)
11. **Q: What is Immutable Infrastructure?**  
    *A:* An operational paradigm where servers or containers are never patched or modified in place. When changes are required, a brand new container image is built, tested, and deployed, replacing the old instance completely.
12. **Q: Why is `--password-stdin` preferred over `-p <password>` in `docker login`?**  
    *A:* Passing passwords directly via `-p` leaves secrets exposed in process tables (`ps aux`) and shell history files. `--password-stdin` reads the password securely from a standard input pipe.
13. **Q: What is Artifact Archiving in Jenkins?**  
    *A:* Saving build outputs (such as JAR files, test XML reports, or logs) directly on the Jenkins controller so they can be downloaded or reviewed from the Jenkins UI.
14. **Q: How can you implement Blue-Green deployment with Docker in Jenkins?**  
    *A:* Maintain two containers: `app-blue` and `app-green`. If `blue` is active on port 8080, deploy the new image to `green` on port 8081. Run automated health checks against port 8081. If successful, update an Nginx reverse proxy to forward port 80 to 8081, and shut down `blue`.
15. **Q: What is Vulnerability Scanning in container pipelines?**  
    *A:* Using automated security scanners (such as Trivy, Snyk, or Clair) during the CI pipeline to inspect base OS packages and dependencies inside the Docker image for known CVEs before pushing to registries.
16. **Q: How does Jenkins execute builds inside a transient Docker container using `agent { docker { ... } }`?**  
    *A:* Jenkins automatically launches a Docker container using the specified image (e.g., `maven:3.8-openjdk-17`), mounts the workspace folder inside it, executes all stage shell steps inside the container, and terminates the container upon completion.
17. **Q: What is an ephemeral build agent?**  
    *A:* A build agent container provisioned on-demand solely to execute a single pipeline job and destroyed immediately afterward, ensuring zero build-to-build contamination.
18. **Q: What is the purpose of image pruning in CI/CD build servers?**  
    *A:* Build servers create dozens of images daily, quickly exhausting disk storage. Automated pruning (`docker image prune -af --filter "until=168h"`) removes untagged and stale images.
19. **Q: How do you configure Slack or email notifications for pipeline status in Jenkins?**  
    *A:* By installing the Slack Notification Plugin and adding `slackSend channel: '#deployments', color: 'good', message: 'Build Successful'` in the `post { success {} }` block.
20. **Q: What is Continuous Delivery vs. Continuous Deployment in the context of this pipeline?**  
    *A:* If the pipeline builds and pushes the image to Docker Hub and pauses for manual approval before running `docker run`, it is Continuous Delivery. If it automatically deploys to production without approval, it is Continuous Deployment.

### Practical Scenario-Based Questions (5)
21. **Scenario:** *During a pipeline build, the `Push to Docker Hub` stage fails with `no space left on device`. How do you resolve this immediately and prevent future occurrences?*  
    *Answer:* Immediately run `docker system prune -af --volumes` on the host to free unused layers. Long-term fix: Add a post-build step in the `Jenkinsfile` or a nightly cron job on the Jenkins agent executing `docker image prune -f` to clean up dangling layers after every build.
22. **Scenario:** *A critical production security CVE is announced in Python 3.9-alpine. How does this CI/CD pipeline remediate the vulnerability?*  
    *Answer:* Update `Dockerfile` to `python:3.11-alpine` (or the patched base image version). Commit and push to GitHub. The CI/CD pipeline automatically checks out code, runs tests, builds the patched image, pushes it to Docker Hub, and redeploys the container in minutes.
23. **Scenario:** *A newly deployed container crashes on startup because an environment variable `DATABASE_URL` is missing. How should the pipeline have caught this?*  
    *Answer:* By including an automated container smoke test step in the `Deploy` stage: After launching the container, the pipeline runs `docker inspect -f '{{.State.Running}}' <container_name>` and polls `curl -f http://localhost:9090/health`. If the endpoint fails within 30 seconds, the pipeline fails and automatically executes rollback to the previous image tag.
24. **Scenario:** *A rogue developer tries to access Docker Hub credentials to push malicious images from their own workstation. Can they extract credentials from Jenkins?*  
    *Answer:* No. Jenkins stores credentials with AES encryption on disk. In pipelines, credentials are injected only into the memory of the execution process and masked with `****` in console logs. With proper Role-Based Access Control (RBAC), developers cannot view credentials in the Jenkins UI.
25. **Scenario:** *An organization wants to deploy containers across 10 virtual machines instead of a single server. Why does this simple Jenkins `docker run` deployment fall short?*  
    *Answer:* `docker run` operates only on a single host. It lacks multi-node load balancing, auto-scaling, inter-host networking, rolling updates, and self-healing. This requires a **Container Orchestrator** like **Kubernetes** (Experiment 10).

---

## 7. Real-World Applications
* **Automated Cloud Delivery:** Used by tech organizations to automatically build, test, and push microservice images to Amazon ECR, Google Artifact Registry, or Azure Container Registry on every merged PR.
* **Feature Branch Preview Deployments:** Teams spin up isolated preview containers accessible via dynamic URLs for every pull request, allowing QA teams to test features before merging to production.

---

# Experiment 9: Demonstrating Maven Build Lifecycle for Java Applications

## 1. Experiment Overview
* **Experiment Number:** 09
* **Title:** Demonstrating Maven Build Lifecycle for Java Applications
* **Course Outcome:** CO5 – Implement build automation and container orchestration for scalable applications.
* **Aim:** To demonstrate the working of the Apache Maven build lifecycle by creating, configuring, compiling, testing, and packaging a Java application using Maven in Visual Studio Code / Terminal.
* **Objectives:**
  1. To understand the three built-in Maven lifecycles: **Clean**, **Default (Build)**, and **Site**.
  2. To master the 8 key phases of the Default build lifecycle: `validate`, `compile`, `test`, `package`, `verify`, `install`, and `deploy`.
  3. To create a Maven project using the standard directory layout and configure `pom.xml` with dependencies and plugins.
  4. To execute Maven lifecycle commands sequentially in the terminal and analyze intermediate artifacts in `target/`.
  5. To execute the packaged standalone executable JAR and verify application behavior.
* **Tools and Technologies Required:** macOS Terminal / VS Code, Java JDK 17+, Apache Maven 3.9+, JUnit 5 Jupiter, VS Code Java Extension Pack.
* **Prerequisites:** Working knowledge of Java programming fundamentals and command-line execution.

---

## 2. Concepts & Theoretical Background

### 2.1 What is Apache Maven?
Apache Maven is a premier open-source build automation and project management tool primarily used for Java applications. Maven revolutionizes Java builds through two central concepts:
1. **Convention over Configuration:** Standardized project structure. Developers don't write complex build scripts; Maven automatically knows where source files, test files, and output binaries reside.
2. **Declarative Dependency Management:** Instead of manually hunting down `.jar` files and managing transitive library versions, dependencies are declared in `pom.xml`. Maven automatically downloads libraries and their dependencies from Maven Central into a local repository (`~/.m2/repository`).

```
+-----------------------------------------------------------------------------------------------+
|                               STANDARD MAVEN PROJECT DIRECTORY LAYOUT                         |
|                                                                                               |
|  demo/                                                                                        |
|  ├── pom.xml                     <-- Project Object Model: coordinates, dependencies, plugins |
|  └── src/                                                                                     |
|      ├── main/                                                                                |
|      │   ├── java/com/example/   <-- Application production Java source code                  |
|      │   └── resources/          <-- Application config files (properties, YAML, SQL)         |
|      └── test/                                                                                |
|          ├── java/com/example/   <-- Unit and Integration test classes (JUnit)                |
|          └── resources/          <-- Test-specific configuration profiles                     |
+-----------------------------------------------------------------------------------------------+
```

### 2.2 Maven Lifecycles and Default Phases
Maven defines three independent built-in lifecycles:
* **Clean Lifecycle:** Cleans up previous build artifacts (`pre-clean`, `clean`, `post-clean`).
* **Default Lifecycle:** Handles compilation, testing, packaging, and deployment.
* **Site Lifecycle:** Generates documentation and site reports.

#### The Default Build Lifecycle Phases
When you execute any phase, Maven automatically executes all preceding phases in sequence!

```
[ validate ] -> [ compile ] -> [ test ] -> [ package ] -> [ verify ] -> [ install ] -> [ deploy ]
```

| Phase | Description |
| :--- | :--- |
| **`validate`** | Validates the project structure and verifies all required POM information is present. |
| **`compile`** | Compiles the main Java source code (`src/main/java`) into `.class` files in `target/classes`. |
| **`test`** | Compiles and executes unit test cases (`src/test/java`) using test frameworks like JUnit. |
| **`package`** | Takes the compiled code and packages it into its distributable format (e.g., `.jar` or `.war`). |
| **`verify`** | Runs integration tests and checks to verify that quality and packaging criteria are satisfied. |
| **`install`** | Copies the packaged JAR into the local repository cache (`~/.m2/repository`) for use as a dependency in other local projects. |
| **`deploy`** | Uploads the final artifact to an enterprise remote repository (e.g., Nexus, JFrog Artifactory) for team distribution. |

---

## 3. Complete Implementation: Maven Java Project Step-by-Step

### Directory Context
Open macOS Terminal. Navigate to your workspace directory (e.g., `~/Desktop/devops-lab`):

```bash
mkdir -p ~/Desktop/devops-lab
cd ~/Desktop/devops-lab
```

### Step 1: Verify Java and Maven Environment
Ensure JDK 17+ and Maven are accessible:

```bash
java -version
mvn -version
```
* **Expected Output:**
  ```text
  openjdk version "17.0.x" ...
  Apache Maven 3.9.x ...
  ```

### Step 2: Create the Maven Project Structure
Create the project folder hierarchy matching the lab manual:

```bash
mkdir -p demo/src/main/java/com/example
mkdir -p demo/src/test/java/com/example
cd demo
```

### Step 3: Configure `pom.xml`
Create the Project Object Model configuration file specifying GAV coordinates (GroupId, ArtifactId, Version), Java 17 properties, and JUnit 5 Jupiter dependencies:

```bash
cat << 'EOF' > pom.xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <!-- Project Coordinates (GAV) -->
    <groupId>com.example</groupId>
    <artifactId>demo</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>

    <name>demo</name>
    <description>DevOps Lab Experiment 9 - Maven Build Lifecycle Demonstration</description>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <junit.version>5.9.3</junit.version>
    </properties>

    <dependencies>
        <!-- JUnit Jupiter API for writing modern unit tests -->
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>

        <!-- JUnit Jupiter Engine to execute unit tests -->
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <!-- Maven Compiler Plugin -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.11.0</version>
                <configuration>
                    <source>17</source>
                    <target>17</target>
                </configuration>
            </plugin>

            <!-- Maven Surefire Plugin to execute tests during 'test' phase -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.1.2</version>
            </plugin>

            <!-- Maven JAR Plugin to configure executable Main-Class in MANIFEST.MF -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-jar-plugin</artifactId>
                <version>3.3.0</version>
                <configuration>
                    <archive>
                        <manifest>
                            <mainClass>com.example.App</mainClass>
                        </manifest>
                    </archive>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
EOF
```

### Step 4: Write Java Production Source Code
Create `src/main/java/com/example/App.java`:

```bash
cat << 'EOF' > src/main/java/com/example/App.java
package com.example;

public class App {

    public String getGreeting() {
        return "Hello from Maven Project!";
    }

    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println("==================================================");
        System.out.println("  " + app.getGreeting());
        System.out.println("  Math Check (10 + 25): " + app.add(10, 25));
        System.out.println("  Maven Build Lifecycle Executed Successfully!    ");
        System.out.println("==================================================");
    }
}
EOF
```

### Step 5: Write Automated JUnit 5 Unit Test Case
Create `src/test/java/com/example/AppTest.java`:

```bash
cat << 'EOF' > src/test/java/com/example/AppTest.java
package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

    @Test
    @DisplayName("Verify default condition")
    public void testApp() {
        assertTrue(true);
    }

    @Test
    @DisplayName("Verify greeting message content")
    public void testGreeting() {
        App app = new App();
        assertEquals("Hello from Maven Project!", app.getGreeting());
    }

    @Test
    @DisplayName("Verify addition logic")
    public void testAddition() {
        App app = new App();
        assertEquals(35, app.add(10, 25));
    }
}
EOF
```

### Step 6: Execute the Maven Lifecycle Phases Sequentially
Execute each phase in the terminal and observe Maven's actions:

#### 1. Validate Phase
```bash
mvn validate
```
* **Explanation:** Checks POM schema and confirms project layout is compliant.
* **Expected Output:** `BUILD SUCCESS`.

#### 2. Compile Phase
```bash
mvn compile
```
* **Explanation:** Compiles `App.java` into bytecodes.
* **Observe:** Notice the creation of `target/classes/com/example/App.class`.

#### 3. Test Phase
```bash
mvn test
```
* **Explanation:** Compiles test files and executes JUnit 5 tests.
* **Expected Output:**
  ```text
  [INFO] -------------------------------------------------------
  [INFO]  T E S T S
  [INFO] -------------------------------------------------------
  [INFO] Running com.example.AppTest
  [INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.052 s
  [INFO] 
  [INFO] Results:
  [INFO] 
  [INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
  [INFO] 
  [INFO] BUILD SUCCESS
  ```

#### 4. Package Phase
```bash
mvn package
```
* **Explanation:** Executes `validate` -> `compile` -> `test` -> packages compiled classes into `target/demo-1.0-SNAPSHOT.jar`.
* **Observe:** `ls -l target/*.jar`.

#### 5. Install Phase
```bash
mvn install
```
* **Explanation:** Copies the packaged JAR to `~/.m2/repository/com/example/demo/1.0-SNAPSHOT/demo-1.0-SNAPSHOT.jar`. Other Java projects on this computer can now declare `com.example:demo:1.0-SNAPSHOT` as a dependency!

#### 6. Clean Phase
```bash
mvn clean
```
* **Explanation:** Completely deletes the `target/` directory, wiping all compiled artifacts.

### Step 7: Build and Execute the Packaged Standalone JAR
Execute full clean package build and run the packaged application:

```bash
# Package fresh JAR
mvn clean package

# Execute the packaged JAR
java -jar target/demo-1.0-SNAPSHOT.jar
```
* **Expected Output:**
  ```text
  ==================================================
    Hello from Maven Project!
    Math Check (10 + 25): 35
    Maven Build Lifecycle Executed Successfully!    
  ==================================================
  ```

### Step 8: Observe the Target Directory Structure
Inspect the final structure of the `target/` directory:

```bash
find target -maxdepth 3
```
* **Expected Output:**
  ```text
  target
  target/classes
  target/classes/com
  target/classes/com/example
  target/classes/com/example/App.class
  target/test-classes
  target/test-classes/com
  target/test-classes/com/example
  target/test-classes/com/example/AppTest.class
  target/surefire-reports
  target/demo-1.0-SNAPSHOT.jar
  ```

---

## 4. Important Commands Reference

| Command | Purpose | Explanation |
| :--- | :--- | :--- |
| `mvn validate` | Validate POM | Validates project structure, dependencies, and configuration syntax. |
| `mvn compile` | Compile source code | Compiles Java files in `src/main/java` to `.class` files in `target/classes`. |
| `mvn test` | Run unit tests | Compiles `src/test/java` and executes unit test cases using Surefire plugin. |
| `mvn package` | Package artifact | Bundles compiled classes and resources into executable `.jar` or `.war` archive. |
| `mvn verify` | Verify packaging | Runs integration tests and checks package integrity against quality criteria. |
| `mvn install` | Install locally | Installs packaged archive into local repository cache (`~/.m2/repository`). |
| `mvn clean` | Clean workspace | Deletes the `target/` folder to ensure clean, reproducible builds. |
| `mvn clean package -DskipTests` | Fast package | Compiles and packages application while skipping unit test execution. |
| `mvn dependency:tree` | Dependency graph | Displays a complete hierarchical tree of direct and transitive dependencies. |

---

## 5. Troubleshooting Common Maven Errors

1. **Error:** `Fatal error compiling: invalid target release: 17`
   * **Reason:** Your active JDK is older than the `maven.compiler.target` specified in `pom.xml` (e.g., running Java 11 instead of Java 17).
   * **Solution:** Verify `java -version` and ensure `export JAVA_HOME` points to JDK 17+.
2. **Error:** `Non-resolvable parent POM ... Could not transfer artifact ... Unknown host`
   * **Reason:** Maven cannot reach Maven Central (`repo.maven.apache.org`) due to network outage, proxy, or sandbox restrictions.
   * **Solution:** Verify internet connection or configure proxy in `~/.m2/settings.xml`.
3. **Error:** `no main manifest attribute, in target/demo-1.0-SNAPSHOT.jar`
   * **Reason:** The JAR was created without specifying which class contains the `public static void main(String[] args)` method.
   * **Solution:** Add the `maven-jar-plugin` configuration in `pom.xml` specifying `<mainClass>com.example.App</mainClass>`.

---

## 6. Viva and Interview Questions

### Basic Questions (10)
1. **Q: What is Apache Maven?**  
   *A:* An open-source build automation and project management tool based on the Project Object Model (POM) concept, used primarily for Java projects.
2. **Q: What are the three built-in lifecycles in Maven?**  
   *A:* Clean (cleans previous build outputs), Default (handles build, test, and packaging), and Site (generates project documentation).
3. **Q: What are GAV coordinates in Maven?**  
   *A:* The unique identifier triad for any Maven artifact:
   * **GroupId:** The domain or organization package name (e.g., `com.example`).
   * **ArtifactId:** The unique project or module name (e.g., `demo`).
   * **Version:** The release version string (e.g., `1.0.0` or `1.0-SNAPSHOT`).
4. **Q: What is `pom.xml`?**  
   *A:* The Project Object Model XML file that contains all configuration details, dependencies, plugins, goals, and build profiles for a Maven project.
5. **Q: What does `mvn clean` do?**  
   *A:* Deletes the `target/` directory generated by previous builds, ensuring the next build starts from a clean slate.
6. **Q: What is the difference between `mvn compile` and `mvn package`?**  
   *A:* `mvn compile` only compiles Java source code into `.class` files. `mvn package` executes compilation, runs unit tests, and bundles the compiled code into a deployable archive (`.jar` or `.war`).
7. **Q: Where is Maven's local repository located on disk?**  
   *A:* In the user's home directory at `~/.m2/repository`.
8. **Q: What is Maven Central?**  
   *A:* The official public cloud repository maintained by Sonatype where open-source Java libraries and dependencies are hosted.
9. **Q: What does `SNAPSHOT` mean in a Maven version (e.g., `1.0-SNAPSHOT`)?**  
   *A:* It indicates an active, unreleased development version that changes frequently, prompting Maven to check remote repositories for newer updates during builds.
10. **Q: How do you skip unit tests during a Maven build?**  
    *A:* Using the flag: `mvn package -DskipTests` (or `-Dmaven.test.skip=true`).

### Intermediate Questions (10)
11. **Q: What is a Transitive Dependency in Maven?**  
    *A:* If your project depends on Library A, and Library A depends on Library B, Maven automatically resolves and downloads Library B into your project without you declaring Library B explicitly.
12. **Q: What are Dependency Scopes in Maven?**  
    *A:* They restrict the classpath and visibility of a dependency:
    * `compile` (default): Available in all classpaths (build, test, runtime).
    * `provided`: Needed at compile time but provided by runtime container (e.g., Servlet API in Tomcat).
    * `runtime`: Not needed for compilation, needed for execution (e.g., JDBC drivers).
    * `test`: Available only for compiling and running test cases (e.g., JUnit).
13. **Q: How do you resolve dependency version conflicts in Maven?**  
    *A:* Maven uses the **Dependency Mediation (Nearest Definition Wins)** rule: The dependency closest to the project root in the dependency tree takes precedence. Conflicts can be resolved explicitly using `<dependencyManagement>` or `<exclusions>`.
14. **Q: What is the difference between `mvn install` and `mvn deploy`?**  
    *A:* `mvn install` copies the artifact to your local machine repository (`~/.m2/repository`). `mvn deploy` uploads the artifact to an enterprise remote repository (Nexus/Artifactory) for access by other developers across the company.
15. **Q: What is the purpose of the Maven Surefire Plugin?**  
    *A:* To execute unit tests during the `test` phase of the build lifecycle and generate XML and plain-text test execution reports.
16. **Q: What is a "Fat JAR" (or "Uber JAR")?**  
    *A:* A self-contained executable JAR archive that bundles both your application classes AND all third-party dependency libraries inside a single archive (commonly created via Spring Boot Maven plugin or Maven Shade plugin).
17. **Q: What is the difference between Maven and Gradle?**  
    *A:* Maven uses XML configuration (`pom.xml`) and rigid lifecycle conventions. Gradle uses Groovy/Kotlin DSL (`build.gradle`), supports incremental compilation, daemon processes, and builds significantly faster on large codebases.
18. **Q: What is `<dependencyManagement>` used for in multi-module Maven projects?**  
    *A:* To define centralized dependency versions in a root parent POM so child modules inherit consistent dependency versions without specifying version tags individually.
19. **Q: What is the Maven Wrapper (`mvnw`)?**  
    *A:* A script bundled with the project that allows developers and CI/CD servers to run Maven builds without having Maven pre-installed on the host machine.
20. **Q: How can you visualize transitive dependencies in terminal?**  
    *A:* Run `mvn dependency:tree`.

### Practical Scenario-Based Questions (5)
21. **Scenario:** *A junior developer accidentally declares two different versions of `jackson-databind` (2.12.0 and 2.15.2) through transitive dependencies, causing runtime `NoSuchMethodError` crashes. How do you diagnose and fix it?*  
    *Answer:* Run `mvn dependency:tree -Dincludes=com.fasterxml.jackson.core:jackson-databind` to inspect which dependencies pull conflicting versions. Add an `<exclusion>` block in the offending dependency or declare the exact required version inside `<dependencyManagement>` to force consistency.
22. **Scenario:** *A CI pipeline takes 15 minutes to run `mvn package` because it re-downloads all external dependencies from the internet on every build. How do you optimize it?*  
    *Answer:* Cache the `~/.m2/repository` directory across CI runs using Docker volume mounts (`-v maven_cache:/root/.m2`) or CI cache actions. Also set up an in-network caching repository mirror (like Sonatype Nexus) so downloads occur over local LAN.
23. **Scenario:** *An engineer needs to build a project for testing without running 500 slow database integration tests. How do they run only fast unit tests?*  
    *Answer:* Configure Surefire plugin test filters or run: `mvn test -Dtest=*UnitTest` (or use `-DskipITs` if using Failsafe plugin for integration tests).
24. **Scenario:** *You need to package an application with different configuration properties for Development, Staging, and Production environments using Maven. How do you achieve this?*  
    *Answer:* Use **Maven Profiles** (`<profiles>`). Define distinct profile IDs (`dev`, `prod`) with customized property filters and activate them using `mvn package -Pprod`.
25. **Scenario:** *A build fails in Jenkins with `OutOfMemoryError: Java heap space` during the compile stage. How do you fix it in Maven?*  
    *Answer:* Increase JVM memory allocated to the Maven process by exporting the environment variable: `export MAVEN_OPTS="-Xms512m -Xmx2048m"`.

---

## 7. Real-World Applications
* **Standard Java Build Infrastructure:** Apache Maven is the backbone of Java enterprise builds worldwide, powering frameworks like Spring Boot, Apache Spark, and Apache Kafka.
* **Automated CI Packaging:** Jenkins, GitLab CI, and GitHub Actions invoke `mvn clean package` to generate standardized, versioned artifacts for automated deployment pipelines.

---

# Experiment 10: Implementing Container Orchestration and Deployment using Kubernetes

## 1. Experiment Overview
* **Experiment Number:** 10
* **Title:** Implementing Container Orchestration and Deployment using Kubernetes
* **Course Outcome:** CO5 – Implement build automation and container orchestration for scalable applications.
* **Aim:** To implement container orchestration and automated deployment using Kubernetes by initializing a Kubernetes cluster, deploying a containerized application via a Kubernetes Deployment manifest, exposing it to external traffic using a Kubernetes NodePort Service, verifying its execution, scaling replicas dynamically, and performing clean resource teardown.
* **Objectives:**
  1. To understand fundamental container orchestration concepts: auto-scaling, self-healing, rolling zero-downtime updates, and automated load balancing.
  2. To master the Kubernetes control plane and worker node architecture (API Server, etcd, Scheduler, Controller Manager, Kubelet, Kube-proxy).
  3. To write and apply declarative Kubernetes manifests (`deployment.yaml` and `service.yaml`).
  4. To understand the relationship between Pods, ReplicaSets, Deployments, and Services.
  5. To inspect cluster states and monitor pod health using the `kubectl` CLI.
  6. To dynamically scale application replicas from 3 to 5 pods and verify traffic load distribution.
* **Tools and Technologies Required:** macOS Terminal, Docker Desktop with Kubernetes enabled (or Minikube / Kind), `kubectl` CLI, Web Browser.
* **Prerequisites:** Completion of Experiment 7 (Docker containerization) and basic YAML syntax knowledge.

---

## 2. Concepts & Theoretical Background

### 2.1 Why Container Orchestration?
In Experiment 7, we deployed an application inside a single Docker container. While Docker is fantastic for packaging, running containers manually in enterprise production fails when:
* A container crashes at 3:00 AM (who restarts it?).
* Traffic surges 1,000% on Black Friday (who launches 50 new container copies?).
* Traffic drops on Monday morning (who scales containers down to save money?).
* You deploy a new software version (how do you update containers with zero downtime?).
* A physical server catches fire (who migrates containers to healthy servers?).

**Container Orchestration** automates these exact production responsibilities.

```
+-----------------------------------------------------------------------------------------------+
|                            KUBERNETES HIGH-LEVEL ARCHITECTURE                                 |
|                                                                                               |
|  [ MASTER / CONTROL PLANE ]                                                                   |
|  +-----------------------------------------------------------------------------------------+  |
|  |  [ kube-apiserver ] <--- REST API Gateway for kubectl and worker nodes                   |  |
|  |  [ etcd ]           <--- Distributed key-value store for entire cluster state            |  |
|  |  [ kube-scheduler ] <--- Assigns newly created Pods to available Worker Nodes           |  |
|  |  [ kube-controller-manager ] <-- Reconciles desired state vs. actual state (self-healing)  |  |
|  +-----------------------------------------------------------------------------------------+  |
|                                           |                                                   |
|                    +----------------------+----------------------+                            |
|                    |                                             |                            |
|                    v                                             v                            |
|  [ WORKER NODE 1 ]                               [ WORKER NODE 2 ]                            |
|  +--------------------------------------------+  +-----------------------------------------+  |
|  |  [ kubelet ]    <-- Talks to API server    |  |  [ kubelet ]                             |  |
|  |  [ kube-proxy ] <-- Handles network routing |  |  [ kube-proxy ]                          |  |
|  |  [ Container Runtime ] (Docker / containerd)| |  [ Container Runtime ]                  |  |
|  |  +-------------------+ +-----------------+ |  |  +-------------------+ +---------------+ |  |
|  |  | Pod 1 (Nginx app) | | Pod 2 (Nginx app) | |  |  | Pod 3 (Nginx app) | | Pod 4 (Nginx) | |  |
|  |  +-------------------+ +-----------------+ |  |  +-------------------+ +---------------+ |  |
|  +--------------------------------------------+  +-----------------------------------------+  |
+-----------------------------------------------------------------------------------------------+
```

### 2.2 Core Kubernetes Primitives
1. **Pod:** The smallest deployable computing unit in Kubernetes. A Pod encapsulates one or more containers sharing network namespaces (same IP address) and storage volumes.
2. **ReplicaSet:** Ensures that a specified number of identical Pod replicas are running at all times. If a Pod crashes, the ReplicaSet immediately spawns a replacement.
3. **Deployment:** A declarative supervisor above ReplicaSets. Manages declarative pod declarations, rolling zero-downtime updates, version rollbacks, and replica scaling.
4. **Service:** An abstraction defining an unchanging logical set of Pods and a consistent network endpoint (IP address and DNS name) to access them, load-balancing incoming traffic across healthy Pods.
   * **ClusterIP (Default):** Exposes Service on an internal cluster IP (accessible only within cluster).
   * **NodePort:** Exposes Service on each Node's IP at a static port (in range `30000-32767`), accessible externally.
   * **LoadBalancer:** Provisions a cloud provider load balancer (AWS NLB/ALB, GCP LB).

---

## 3. Complete Implementation: Deploying Nginx on Kubernetes

### Directory Context
Open macOS Terminal. Navigate to your workspace directory (e.g., `~/Desktop/devops-lab`):

```bash
mkdir -p ~/Desktop/devops-lab/k8s-demo
cd ~/Desktop/devops-lab/k8s-demo
```

### Step 1: Enable and Verify Kubernetes on Docker Desktop
1. Open **Docker Desktop** on macOS -> Click the **Gear icon (Settings)**.
2. Select **Kubernetes** in the left menu -> Check **Enable Kubernetes** -> Click **Apply & restart**.
3. Verify Kubernetes cluster status in terminal:

```bash
# Verify client and cluster version
kubectl version --client

# Verify cluster connectivity
kubectl cluster-info

# Check active cluster nodes
kubectl get nodes
```
* **Expected Output:**
  ```text
  Client Version: v1.3x.x
  Kubernetes control-plane is running at https://kubernetes.docker.internal:6443
  CoreDNS is running at https://kubernetes.docker.internal:6443/api/v1/namespaces/kube-system/services/kube-dns:dns/proxy

  NAME             STATUS   ROLES           AGE   VERSION
  docker-desktop   Ready    control-plane   10m   v1.3x.x
  ```

### Step 2: Create the Kubernetes Deployment Manifest (`deployment.yaml`)
Create the deployment manifest matching the lab manual specification:

```bash
cat << 'EOF' > deployment.yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: nginx-deployment
  labels:
    app: nginx
spec:
  replicas: 3
  selector:
    matchLabels:
      app: nginx
  template:
    metadata:
      labels:
        app: nginx
    spec:
      containers:
      - name: nginx
        image: nginx:latest
        ports:
        - containerPort: 80
EOF
```
* **Line-by-Line Explanation:**
  * `apiVersion: apps/v1`: Identifies the schema version of the Kubernetes API managing Deployments.
  * `kind: Deployment`: Specifies that we are creating a Deployment controller.
  * `metadata.name: nginx-deployment`: The unique name of this deployment in the namespace.
  * `spec.replicas: 3`: Desired state: Maintain exactly 3 running Pod instances at all times.
  * `spec.selector.matchLabels`: Tells the Deployment controller which Pods belong to it (any Pod labeled `app: nginx`).
  * `template`: The blueprint used to stamp out each Pod instance.
  * `containers`: Defines the container name, Docker image (`nginx:latest`), and exposed container port (`80`).

### Step 3: Apply the Deployment to the Cluster
Execute the declarative apply command:

```bash
# Apply deployment manifest
kubectl apply -f deployment.yaml

# Inspect deployment status
kubectl get deployments

# Inspect created pods
kubectl get pods -o wide
```
* **Explanation:**
  * `kubectl apply -f deployment.yaml`: Sends the desired state specification to the Kubernetes API server.
* **Expected Output:**
  ```text
  deployment.apps/nginx-deployment created

  NAME               READY   UP-TO-DATE   AVAILABLE   AGE
  nginx-deployment   3/3     3            3           15s

  NAME                                READY   STATUS    RESTARTS   AGE   IP          NODE
  nginx-deployment-77b4fdf86c-4j9kp   1/1     Running   0          20s   10.1.0.12   docker-desktop
  nginx-deployment-77b4fdf86c-8x2mp   1/1     Running   0          20s   10.1.0.13   docker-desktop
  nginx-deployment-77b4fdf86c-m9qpl   1/1     Running   0          20s   10.1.0.14   docker-desktop
  ```
  *Notice that all 3 Pods are in `Running` status with independent internal cluster IP addresses.*

### Step 4: Create the Kubernetes Service Manifest (`service.yaml`)
Create the Service manifest to expose the Nginx Pods via NodePort:

```bash
cat << 'EOF' > service.yaml
apiVersion: v1
kind: Service
metadata:
  name: nginx-service
spec:
  type: NodePort
  selector:
    app: nginx
  ports:
  - protocol: TCP
    port: 80
    targetPort: 80
    nodePort: 30080
EOF
```
* **Line-by-Line Explanation:**
  * `kind: Service`: Identifies the resource as a network load balancer endpoint.
  * `type: NodePort`: Exposes the service on each node’s IP at a static port.
  * `selector.app: nginx`: Automatically binds this Service to all Pods labeled `app: nginx`.
  * `port: 80`: The port exposed inside the cluster.
  * `targetPort: 80`: The port on which the container process listens.
  * `nodePort: 30080`: Static host port accessible on macOS (`http://localhost:30080`).

### Step 5: Apply the Service and Access the Application
```bash
# Apply service manifest
kubectl apply -f service.yaml

# Inspect created service
kubectl get services
```
* **Expected Output:**
  ```text
  service/nginx-service created

  NAME            TYPE        CLUSTER-IP       EXTERNAL-IP   PORT(S)        AGE
  kubernetes      ClusterIP   10.96.0.1        <none>        443/TCP        25m
  nginx-service   NodePort    10.105.142.89    <none>        80:30080/TCP   8s
  ```

### Step 6: Verify External Application Access
Access the Nginx web server from terminal or your browser at `http://localhost:30080`:

```bash
curl -I http://localhost:30080
```
* **Expected Output:**
  ```text
  HTTP/1.1 200 OK
  Server: nginx/1.27.x
  Content-Type: text/html
  Content-Length: 615
  Connection: keep-alive
  ```

### Step 7: Inspect All Cluster Resources and Deployment Details
```bash
# View comprehensive overview of all active resources
kubectl get all

# View detailed internal configuration and events
kubectl describe deployment nginx-deployment
```

### Step 8: Demonstrate Dynamic Application Scaling
Scale the application from 3 Pods to 5 Pods dynamically:

```bash
# Scale deployment to 5 replicas
kubectl scale deployment nginx-deployment --replicas=5

# Verify that 5 Pods are running
kubectl get pods
```
* **Expected Output:**
  ```text
  deployment.apps/nginx-deployment scaled

  NAME                                READY   STATUS    RESTARTS   AGE
  nginx-deployment-77b4fdf86c-4j9kp   1/1     Running   0          3m
  nginx-deployment-77b4fdf86c-8x2mp   1/1     Running   0          3m
  nginx-deployment-77b4fdf86c-m9qpl   1/1     Running   0          3m
  nginx-deployment-77b4fdf86c-d4x91   1/1     Running   0          6s
  nginx-deployment-77b4fdf86c-q1w2e   1/1     Running   0          6s
  ```

Scale the application back down to 3 replicas:

```bash
kubectl scale deployment nginx-deployment --replicas=3
kubectl get pods
```

### Step 9: Demonstrate Self-Healing
Kubernetes automatically maintains desired state. If a Pod crashes or is manually deleted, Kubernetes instantly creates a replacement:

```bash
# Delete one pod manually
POD_TO_DELETE=$(kubectl get pods -o jsonpath='{.items[0].metadata.name}')
echo "Deleting pod: $POD_TO_DELETE"
kubectl delete pod $POD_TO_DELETE

# Immediately inspect pods
kubectl get pods
```
* **Observe:** Kubernetes immediately terminates the old pod and provisions a brand new pod within seconds, maintaining exactly 3 replicas!

### Step 10: Clean Up Kubernetes Resources
After finishing the lab, delete the created resources:

```bash
kubectl delete -f service.yaml
kubectl delete -f deployment.yaml
```
* **Expected Output:**
  ```text
  service "nginx-service" deleted
  deployment.apps "nginx-deployment" deleted
  ```

---

## 4. Important Commands Reference

| Command | Purpose | Explanation |
| :--- | :--- | :--- |
| `kubectl cluster-info` | Cluster diagnostics | Prints master plane and core DNS endpoints. |
| `kubectl get nodes` | List cluster nodes | Displays worker and control-plane machines and their ready status. |
| `kubectl apply -f <file.yaml>` | Declarative apply | Creates or updates cluster resources to match the desired state in YAML. |
| `kubectl get pods -o wide` | List Pods with IPs | Displays running pods, restart counts, node placements, and internal IPs. |
| `kubectl get deployments` | List Deployments | Shows desired, current, up-to-date, and available replica counts. |
| `kubectl get services` | List Services | Shows ClusterIPs, NodePorts, and port mappings. |
| `kubectl describe <res> <name>` | Deep resource inspection | Displays detailed metadata, controller rules, and real-time cluster events. |
| `kubectl logs -f <pod-name>` | Follow pod logs | Streams stdout/stderr logs from the container running inside the Pod. |
| `kubectl scale deployment <name> --replicas=N` | Dynamic scaling | Immediately scales the number of running pod instances up or down. |
| `kubectl delete -f <file.yaml>` | Resource teardown | Gracefully deletes all resources defined in the specified manifest file. |

---

## 5. Troubleshooting Common Kubernetes Errors

1. **Error:** `The connection to the server localhost:8080 was refused - did you specify the right host or port?`
   * **Reason:** `kubectl` is trying to reach a default local cluster, but Docker Desktop Kubernetes is disabled or stopped.
   * **Solution:** Open Docker Desktop Settings -> Kubernetes -> Ensure "Enable Kubernetes" is checked and status indicates running.
2. **Error:** Pods stuck in `CrashLoopBackOff`
   * **Reason:** The application container starts, throws an unhandled exception or exits immediately, and crashes. Kubernetes repeatedly tries to restart it.
   * **Solution:** Inspect crash logs using `kubectl logs <pod-name>` or previous crash logs using `kubectl logs <pod-name> --previous`.
3. **Error:** `The Service "nginx-service" is invalid: spec.ports[0].nodePort: Invalid value: 80: provided port is not in the valid range. The range of valid ports is 30000-32767`
   * **Reason:** NodePort static ports must fall strictly within the Kubernetes default port allocation range: 30000 to 32767.
   * **Solution:** Set `nodePort: 30080` (or omit `nodePort` to allow Kubernetes to assign one automatically).

---

## 6. Viva and Interview Questions

### Basic Questions (10)
1. **Q: What is Kubernetes (K8s)?**  
   *A:* An open-source container orchestration platform originally developed by Google that automates the deployment, scaling, management, and networking of containerized applications.
2. **Q: Why is Kubernetes called K8s?**  
   *A:* It is an abbreviation: There are 8 letters between the starting letter "K" and ending letter "s".
3. **Q: What is the smallest deployable object in Kubernetes?**  
   *A:* A **Pod**.
4. **Q: What is the difference between a Pod and a Container?**  
   *A:* A Container is an isolated process created from an image. A Pod is a Kubernetes abstraction that wraps one or more tightly coupled containers sharing network namespaces, storage volumes, and IP address.
5. **Q: What is the Control Plane (Master Node) in Kubernetes?**  
   *A:* The collection of core cluster components (API Server, etcd, Scheduler, Controller Manager) that manages cluster state, schedules pods, and handles cluster events.
6. **Q: What is a Worker Node in Kubernetes?**  
   *A:* A physical or virtual server that hosts and runs container workloads inside Pods, managed by the Kubelet agent.
7. **Q: What is `kubectl`?**  
   *A:* The official command-line client used to communicate with the Kubernetes cluster API server via RESTful HTTP requests.
8. **Q: What is a Kubernetes Deployment?**  
   *A:* A high-level controller that declaratively manages Pods and ReplicaSets, enabling rolling updates, version rollbacks, and automated scaling.
9. **Q: What is a Kubernetes Service?**  
   *A:* An abstraction that defines a consistent, permanent network IP and DNS name to route traffic across dynamic, ephemeral Pods.
10. **Q: What is `etcd` in Kubernetes?**  
    *A:* A highly available, distributed key-value database used as Kubernetes' single source of truth for all cluster configuration and state data.

### Intermediate Questions (10)
11. **Q: How does Kubernetes achieve Self-Healing?**  
    *A:* The `kube-controller-manager` continuously runs control loops comparing actual state against desired state. If a Pod crashes, is killed, or a node dies, the controller automatically provisions a new replacement Pod on a healthy node to restore desired replicas.
12. **Q: What are the differences between Service types: ClusterIP, NodePort, and LoadBalancer?**  
    *A:*
    * **ClusterIP:** Accessible only inside the Kubernetes cluster network.
    * **NodePort:** Exposes service on a static high port (`30000-32767`) on every cluster node's IP, accessible externally.
    * **LoadBalancer:** Automatically provisions an external cloud load balancer (e.g., AWS NLB) pointing to the NodePort service.
13. **Q: What is the role of the Kubelet?**  
    *A:* The node agent running on every worker node. It receives Pod specifications (`PodSpecs`) from the API Server and instructs the container runtime (e.g., containerd) to run and monitor the containers.
14. **Q: What is `kube-proxy`?**  
    *A:* A network proxy running on each node that maintains network rules (using `iptables` or `IPVS`) to route traffic destined for Service IPs to the appropriate backend Pod IPs.
15. **Q: What is a Rolling Update in Kubernetes?**  
    *A:* An update strategy that progressively replaces instances of the old version with instances of the new version one by one, ensuring zero downtime and continuous service availability.
16. **Q: What is a Namespace in Kubernetes?**  
    *A:* A logical partition within a physical cluster used to divide cluster resources between multiple teams, projects, or environments (e.g., `dev`, `staging`, `prod`).
17. **Q: What is the difference between Liveness and Readiness Probes?**  
    *A:* A **Liveness Probe** checks if the container is alive (if it fails, Kubernetes restarts the container). A **Readiness Probe** checks if the container is ready to accept incoming user traffic (if it fails, Kubernetes stops sending traffic to the Pod without restarting it).
18. **Q: What is a ConfigMap vs. a Secret in Kubernetes?**  
    *A:* Both store external configuration data outside application code. **ConfigMaps** store plain-text key-value configuration. **Secrets** store sensitive data (passwords, tokens, keys) encoded in Base64 or encrypted at rest in etcd.
19. **Q: What is Horizontal Pod Autoscaler (HPA)?**  
    *A:* A controller that automatically increases or decreases the number of Pod replicas based on observed CPU utilization, memory consumption, or custom application metrics.
20. **Q: How do you rollback a failed Kubernetes deployment?**  
    *A:* Run `kubectl rollout undo deployment/<deployment-name>`.

### Practical Scenario-Based Questions (5)
21. **Scenario:** *A new version of an application is deployed, but pods immediately enter `ImagePullBackOff`. What are the root causes?*  
    *Answer:* The specified container image tag does not exist, the image repository name has a typo, the network cannot reach the container registry, or the registry is private and Kubernetes lacks the required `imagePullSecrets` credentials.
22. **Scenario:** *An application Pod is consuming 100% CPU and not responding to user requests, but Kubernetes does not restart it. Why?*  
    *Answer:* The Pod manifest lacks a configured **Liveness Probe**. Kubernetes only restarts containers automatically if the container process crashes or if a configured liveness probe fails. Adding an HTTP liveness probe detects the unresponsiveness and restarts the Pod automatically.
23. **Scenario:** *A developer wants to inspect the live environment variables and filesystem inside a failing Pod. How can they do this?*  
    *Answer:* Run `kubectl exec -it <pod-name> -- /bin/sh` (or `bash`) to open an interactive shell session inside the container, or run `kubectl describe pod <pod-name>` to view container events.
24. **Scenario:** *During a database deployment in Kubernetes, a worker node restarts, and the new database Pod is created on another node with an empty database. Why was data lost?*  
    *Answer:* The database did not use persistent storage. Pods are ephemeral. Database workloads must attach to a **PersistentVolume (PV)** via a **PersistentVolumeClaim (PVC)** so storage persists independently of pod lifecycles.
25. **Scenario:** *A high-traffic e-commerce application experiences a 5x traffic spike. How can Kubernetes handle this automatically without human intervention?*  
    *Answer:* Configure a **Horizontal Pod Autoscaler (HPA)** specifying `minReplicas: 3`, `maxReplicas: 30`, and `targetCPUUtilizationPercentage: 70`. When average CPU exceeds 70%, HPA automatically scales up pod replicas, and the Kubernetes Service load-balances traffic across all running pods.

---

## 7. Real-World Applications
* **Global Cloud Services:** Spotify, Airbnb, and Pokemon GO run their entire global backend microservice fleets on Kubernetes clusters managing hundreds of thousands of pods across multiple geographic cloud regions.
* **Zero-Downtime SaaS Deployments:** Enterprises deploy software updates hundreds of times a day using Kubernetes rolling updates, ensuring zero disrupted connections for active customers.

---

# Master DevOps Tools Summary

| Tool | Category | Primary Function | Real-World Enterprise Role |
| :--- | :--- | :--- | :--- |
| **Git** | Version Control (VCS) | Distributed source code tracking | Tracks changes, branching, commit history, and offline development. |
| **GitHub** | Code Collaboration & Hosting | Remote repository hosting & review | Manages Pull Requests, code reviews, issue tracking, and branch rules. |
| **GitFlow** | Branching Methodology | Standardized branching workflow | Manages feature isolation, release stabilization, and urgent production hotfixes. |
| **Jenkins** | CI/CD Automation Server | Orchestrates build, test, and release | Executes pipelines upon GitHub pushes, runs tests, builds containers. |
| **Docker** | Containerization Platform | Packages apps and dependencies | Creates lightweight, portable, immutable container images. |
| **Maven** | Java Build Automation | Dependency management & packaging | Resolves dependencies, compiles Java, runs JUnit tests, builds JARs. |
| **Kubernetes** | Container Orchestration | Automates deployment & scaling | Manages multi-container clusters, self-healing, rolling updates, load balancing. |

---

# DevOps Command Reference Cheat Sheet

### 1. Git & GitHub
```bash
git init                                   # Initialize new Git repository
git status                                 # Show working tree status
git add <file> / git add .                 # Stage changes for commit
git commit -m "message"                    # Save staged snapshot
git log --oneline --graph                  # View visual commit history
git checkout -b <branch>                   # Create and switch to new branch
git merge <branch>                         # Merge branch into current branch
git remote add origin <url>                # Link local repo to GitHub
git push -u origin <branch>                # Push commits to remote
git pull origin <branch>                   # Fetch and merge remote changes
```

### 2. Maven
```bash
mvn clean                                  # Delete target/ directory
mvn compile                                # Compile Java source files
mvn test                                   # Execute unit test cases
mvn package                                # Package compiled code into JAR/WAR
mvn install                                # Install artifact into local ~/.m2
mvn clean package -DskipTests              # Fast build skipping tests
mvn dependency:tree                        # View dependency hierarchy
```

### 3. Docker
```bash
docker build -t <name:tag> .               # Build image from Dockerfile
docker run -d -p <host:cont> <image>       # Run background container with port mapping
docker ps                                  # List active containers
docker ps -a                               # List all containers (including stopped)
docker images                              # List local Docker images
docker logs -f <container>                 # Follow container console logs
docker exec -it <container> sh             # Open interactive shell in container
docker stop <container>                    # Stop container
docker rm <container>                      # Delete stopped container
docker rmi <image>                         # Delete image
```

### 4. Kubernetes (kubectl)
```bash
kubectl cluster-info                       # Check cluster endpoint health
kubectl get nodes                          # List cluster nodes
kubectl apply -f <manifest.yaml>           # Apply declarative resource configuration
kubectl get pods -o wide                   # List running pods with IP details
kubectl get deployments                    # List deployments
kubectl get services                       # List services and ports
kubectl describe <resource> <name>         # View deep resource metadata and events
kubectl logs -f <pod-name>                 # Follow pod logs
kubectl scale deployment <name> --replicas=N # Scale pod replicas dynamically
kubectl delete -f <manifest.yaml>          # Delete all resources in manifest
```

---

# Core Architectural Differences Matrix

| Dimension | Git vs. GitHub | CI vs. CD | Docker vs. Kubernetes | Jenkins vs. Maven | VM vs. Container |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Core Concept** | Git is local CLI software; GitHub is a cloud web platform. | CI automates build/test; CD automates release/deploy. | Docker creates single containers; Kubernetes orchestrates multi-host clusters. | Jenkins orchestrates entire pipelines; Maven builds Java projects. | VMs virtualize hardware; Containers virtualize OS kernel. |
| **Level** | Tool vs. Service | Integration vs. Delivery | Packaging vs. Orchestration | Workflow vs. Build Tool | Infrastructure vs. Process |
| **Execution** | Runs locally on laptop | Runs on CI build server | Runs on Docker Engine | Runs on Controller/Agents | Hypervisor vs. Container Runtime |
| **Primary Goal** | Version control vs. Collaboration | Early bug detection vs. Continuous release | Consistency vs. Scalability & Self-healing | Automation vs. Compilation & Packaging | Isolation vs. Speed & Efficiency |

---

# Frequently Asked Technical Interview Questions

1. **What is the difference between Continuous Delivery and Continuous Deployment?**  
   *Answer:* Both automate the testing and packaging of code. Continuous Delivery stops before production, requiring a manual human approval button to release. Continuous Deployment automatically deploys every passing build directly to live production servers with zero manual intervention.
2. **What happens under the hood when you run `git commit`?**  
   *Answer:* Git writes the modified file contents into new **Blob** objects compressed with zlib and hashes them with SHA-1. It creates a **Tree** object referencing the directory hierarchy and blob hashes. Finally, it creates a **Commit** object containing the tree hash, author name, timestamp, commit message, and parent commit hash, and updates the active branch reference pointer in `.git/refs/heads/`.
3. **Why do we need a Container Registry when we already have GitHub?**  
   *Answer:* GitHub stores human-readable source code text files. A Container Registry (like Docker Hub or AWS ECR) stores compiled, binary layered filesystem images that can be thousands of megabytes in size, optimized for rapid distribution and pulling by container runtimes.
4. **How do Kubernetes Pods communicate with each other?**  
   *Answer:* Every Pod in a Kubernetes cluster gets its own unique, routable cluster IP address. Pods can communicate directly with any other Pod in the cluster without NAT, regardless of which physical node they reside on, using flat SDN cluster networking (like Calico, Flannel, or VPC CNI).
5. **What is GitOps and how does it relate to Kubernetes?**  
   *Answer:* GitOps is an operating model where Git is the single source of truth for declarative infrastructure and applications. An automated agent inside the Kubernetes cluster (like ArgoCD or Flux) continuously monitors the Git repository and automatically synchronizes the live cluster state with the manifests in Git.

---

# Recommended Revision Roadmap

To master DevOps concepts systematically for practical exams and job interviews, follow this proven sequential revision order:

```
[ Step 1: Culture & Life Cycle (Exp 1) ]
                  |
                  v
[ Step 2: Version Control Foundations (Exp 2 & Exp 3) ]
                  |
                  v
[ Step 3: Enterprise Team Branching (Exp 4) ]
                  |
                  v
[ Step 4: Build Automation with Maven (Exp 9) ]
                  |
                  v
[ Step 5: Continuous Integration with Jenkins (Exp 5 & Exp 6) ]
                  |
                  v
[ Step 6: Containerization with Docker (Exp 7) ]
                  |
                  v
[ Step 7: End-to-End Container CI/CD (Exp 8) ]
                  |
                  v
[ Step 8: Production Orchestration with Kubernetes (Exp 10) ]
                  |
                  v
[ Step 9: Complete Hands-on Project Implementation (README 2) ]
```

---
*End of DevOps Laboratory Experiments Manual & Viva Guide.*
