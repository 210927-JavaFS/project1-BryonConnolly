package com.revature.controllers;

import java.util.List;

import com.revature.models.Avenger;
import com.revature.services.UserService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class AvengerController implements Controller {

	private UserService avengerService = new UserService();

	public Handler getAllAvengers = (ctx) -> {
		if (ctx.req.getSession(false) != null) {
			List<Avenger> list = avengerService.getAllAvengers();

			ctx.json(list);
			ctx.status(200);
		} else {
			ctx.status(401);
		}
	};

	public Handler getAvenger = (ctx) -> {
		if (ctx.req.getSession(false) != null) {
			try {
				String idString = ctx.pathParam("avenger");
				int id = Integer.parseInt(idString);
				Avenger avenger = avengerService.getAvenger(id);
				ctx.json(avenger);
				ctx.status(200);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				ctx.status(406);
			}
		} else {
			ctx.status(401);
		}
	};

	public Handler addAvenger = (ctx) -> {
		if (ctx.req.getSession(false) != null) {
			Avenger avenger = ctx.bodyAsClass(Avenger.class);
			if (avengerService.addAvenger(avenger)) {
				ctx.status(201);
			} else {
				ctx.status(400);
			}
		} else {
			ctx.status(401);
		}
	};

	public Handler updateAvenger = (ctx) -> {
		if (ctx.req.getSession(false) != null) {
			Avenger avenger = ctx.bodyAsClass(Avenger.class);
			if (avengerService.updateAvenger(avenger)) {
				ctx.status(200);
			} else {
				ctx.status(400);
			}
		} else {
			ctx.status(401);
		}
	};

	public Handler deleteAvenger = (ctx) -> {
		if (ctx.req.getSession(false) != null) {
			String id = ctx.pathParam("avenger");
			try {
				int avenger = Integer.parseInt(id);
				if (avengerService.deleteAvenger(avenger)) {
					ctx.status(200);
				} else {
					ctx.status(400);
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
				ctx.status(406);
			}
		} else {
			ctx.status(401);
		}
	};

	@Override
	public void addRoutes(Javalin app) {
		app.get("/avengers", this.getAllAvengers);
		app.get("/avengers/:avenger", this.getAvenger);
		app.post("/avengers", this.addAvenger);
		app.put("/avengers", this.updateAvenger);
		app.delete("/avengers/:avenger", this.deleteAvenger);
	}

}
