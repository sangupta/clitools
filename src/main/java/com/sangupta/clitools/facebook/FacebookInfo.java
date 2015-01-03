package com.sangupta.clitools.facebook;

import com.google.gson.FieldNamingPolicy;
import com.sangupta.jerry.http.WebInvoker;
import com.sangupta.jerry.http.WebResponse;
import com.sangupta.jerry.print.ConsoleTable;
import com.sangupta.jerry.print.ConsoleTable.ConsoleTableLayout;
import com.sangupta.jerry.util.AssertUtils;
import com.sangupta.jerry.util.GsonUtils;

import io.airlift.command.Arguments;
import io.airlift.command.Command;

@Command(name = "fbinfo", description = "Show information about a facebook account or page")
public class FacebookInfo implements Runnable {
	
	@Arguments(description = "the account or page to show information for")
	public String account;
	
	public static void main(String[] args) {
		FacebookInfo info = new FacebookInfo();
		info.account = "shirleysetiamusic";
		info.run();
	}

	@Override
	public void run() {
		if(AssertUtils.isEmpty(this.account)) {
			System.out.println("Account or page name is required.");
			return;
		}
		
		String url = "https://graph.facebook.com/" + this.account.toLowerCase();
		WebResponse response = WebInvoker.getResponse(url);
		if(response ==  null) {
			System.out.println("Unable to fetch response from server");
			return;
		}
		
		if(!response.isSuccess()) {
			System.out.println("Non-success response from server as: " + response.trace());
			return;
		}
		
		FacebookInfoResponse info = GsonUtils.getGson(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).fromJson(response.getContent(), FacebookInfoResponse.class);
		
		// start display
		
		ConsoleTable table = new ConsoleTable(ConsoleTableLayout.MULTI_LINE);
		table.setColumnSeparator(": " );
		table.addRow("User Name", info.username);
		table.addRow("ID", info.id);
		table.addRow("Name", info.name);
		table.addRow("Link", info.link);
		table.addRow("Website", info.website);
		table.addRow("Talking About", info.talkingAboutCount);
		table.addRow("Likes", info.likes);
		table.addRow("Bio", info.bio);
		table.addRow("About", info.about);
		table.addRow("Category", info.category);
		table.addRow("Hometown", info.hometown);
		
		table.write(System.out);
	}

	private static class FacebookInfoResponse {
		
		String id;
		String about;
		String bio;
		String category;
		String hometown;
		long likes;
		String link;
		String name;
		String username;
		String website;
		long talkingAboutCount;
		
	}
}
