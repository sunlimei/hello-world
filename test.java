import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DependencyCheckScanner {

    public static void main(String[] args) {
        // dependency-check的安装路径
        String dependencyCheckPath = "/path/to/dependency-check/bin/dependency-check.sh";
        // 扫描的目标目录
        String projectPath = "/path/to/your/project";

        // 构建命令
        ProcessBuilder processBuilder = new ProcessBuilder(
                dependencyCheckPath,
                "--project", "MyProject",
                "--scan", projectPath,
                "--out", "/path/to/output/report"
        );

        // 合并错误流到标准输出
        processBuilder.redirectErrorStream(true);

        try {
            // 启动进程
            Process process = processBuilder.start();

            // 读取输出
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // 等待进程结束
            int exitCode = process.waitFor();
            System.out.println("扫描完成，退出码: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        void doSomething(int a, int b) { // Noncompliant, "b" is unused
  compute(a);
}
        
    }
}


public class Car{

  public DriveTrain drive;

  public void tearDown(){...}

  public void drive() {...}  // Noncompliant; duplicates field name
}

public class MyCar extends Car{
  public void teardown(){...}  // Noncompliant; not an override. It it really what's intended?

  public void drivefast(){...}

  public void driveFast(){...} //Huh?
}
