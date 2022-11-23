package com.gmail.juyonglee0208.lifeCycle.join.ex01;

class FileDownLoader extends Thread {

    int fileSize;

    public FileDownLoader(String name, int fileSize) {
        super(name);
        this.fileSize = fileSize;
    }

    @Override
    public void run() {
        int download = 0;
        try {
            for (int i = 0; i < 1000; i++) {
                download += (int) (Math.random() * 3000) + 1;
                double downloadProgress = (double) download / fileSize * 100;
                if (downloadProgress < 100) {
                    System.out.printf("[%d/%5d] %10s %.2f%%\n", download, fileSize, getName(),
                        downloadProgress);
                } else {
                    System.out.printf("[%d/%5d] 100%%\n", fileSize, fileSize);
                   interrupt();
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(isInterrupted());
        }
    }
}
