package com.revature.controllers;

import java.util.List;

import com.revature.models.Home;
import com.revature.services.HomeService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class HomeController implements Controller {

	private HomeService homeService = new HomeService();

	public Handler getAllHomes = (ctx) -> {
		if (ctx.req.getSession(false) != null) {
			List<Home> list = homeService.getAllHomes();

			ctx.json(list);
			ctx.status(200);
		} else {
			ctx.status(401);
		}
	};

	public Handler getHome = (ctx) -> {
		if (ctx.req.getSession(false) != null) {
			Home home = homeService.getHome(ctx.pathParam("home"));
			ctx.json(home);
			ctx.status(200);
		} else {
			ctx.status(401);
		}
	};

	public Handler addHome = (ctx) -> {
		if (ctx.req.getSession(false) != null) {
			Home home = ctx.bodyAsClass(Home.class);
			if (homeService.addHome(home)) {
				ctx.status(201);
			} else {
				ctx.status(400);
			}
		} else {
			ctx.status(401);
		}
	};

	public Handler updateHome = (ctx) -> {
		if (ctx.req.getSession(false) != null) {
			Home home = ctx.bodyAsClass(Home.class);
			if (homeService.updateHome(home)) {
				ctx.status(200);
			} else {
				ctx.status(400);
			}
		} else {
			ctx.status(401);
		}
	};

	public Handler deleteHome = (ctx) -> {
		if (ctx.req.getSession(false) != null) {
			String home = ctx.pathParam("home");
			if (homeService.deleteHome(home)) {
				ctx.status(200);
			} else {
				ctx.status(400);
			}
		} else {
			ctx.status(401);
		}
	};

	@Override
	public void addRoutes(Javalin app) {
		app.get("/homes", this.getAllHomes);
		app.get("/homes/:home", this.getHome);
		app.post("/homes", this.addHome);
		app.put("/homes", this.updateHome);
		app.delete("/homes/:home", this.deleteHome);
	}

}
