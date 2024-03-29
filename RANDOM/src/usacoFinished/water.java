package usacoFinished;

import java.util.Scanner;

public class water {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numPastures = scan.nextInt();
		int[][] costs = new int[numPastures][numPastures];
		int[] wellCost = new int[numPastures];
		for (int i = 0; i < numPastures; i++) {
			wellCost[i] = scan.nextInt();
		}

		for (int i = 0; i < numPastures; i++) {
			for (int j = 0; j < numPastures; j++) {
				costs[i][j] = scan.nextInt();
			}
		}

		boolean[] visited = new boolean[numPastures];
		int[] distances = new int[numPastures];

		for (int i = 0; i < numPastures; i++) {
			distances[i] = wellCost[i];
		}

		int total = 0;
		for (int i = 0; i < numPastures; i++) {
			int min = -1;
			for (int j = 0; j < numPastures; j++) {
				if (!visited[j] && (min == -1 || distances[j] < distances[min])) {
					min = j;
				}
			}
			visited[min] = true;
			total += distances[min];
			for (int j = 0; j < numPastures; j++) {
				if (min != j && costs[min][j] < distances[j]) {
					distances[j] = costs[min][j];
				}
			}
		}

		System.out.println(total);
		scan.close();
	}
}
