package com.icaikee.wrap.scheduler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.scheduling.annotation.Scheduled;

//@Service
public class Counter {

	@Scheduled(cron = "*/5 * * * * ?")
	public void count() {
		File file = new File("E:/programme/imgrepository/COUNTER.txt");
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			Map<String, Integer> map = new HashMap<String, Integer>();
			while ((tempString = reader.readLine()) != null) {
				String[] array = tempString.split(" ");
				for (int i = 0; i < array.length; i++) {
					if ("[X]".equals(array[i])) {
						Integer c = map.get(array[i + 2]);
						if (c == null)
							c = 0;
						c++;
						map.put(array[i + 2], c);
					}
				}
			}
			for (String s : map.keySet()) {
				String type = s.substring(0, 5);
				String id = s.substring(5, s.length());
				System.out.println("type: " + type + " id: " + id + " count: " + map.get(s));
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}

}
