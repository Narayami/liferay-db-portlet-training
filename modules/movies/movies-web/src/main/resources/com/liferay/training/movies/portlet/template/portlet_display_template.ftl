<#--

	This is an example Application Display Template for the movies Application.

	Application display templates can be used to modify the look of a
	specific application.

	Please use the left panel to quickly add commonly used variables.
	Autocomplete is also available and can be invoked by typing "${".


-->

<div class="container-fluid-1280">

	<h1>This is Using a Custom Application Display Template</h1>

	<div class="flex-container">

		<@liferay_ui["search-container"] emptyResultsMessage="there-are-no-movies-for-this-class">
			<@liferay_ui["search-container-results"] results=entries />
			<@liferay_ui["search-container-row"]
				className="com.liferay.training.movies.model.Movie"
				modelVar="movie">

				<@liferay_portlet["renderURL"] var="viewMoviesURL">
					<@liferay_portlet["param"] name="mvcRenderCommandName"
						value="/movies/movies/view" />
					<@liferay_portlet["param"] name="redirect" value="${currentURL}" />
					<@liferay_portlet["param"] name="movieId"
						value="${movie.getMovieId()}" />
				</@>
				
				<@liferay_frontend["icon-vertical-card"] icon="folder"
					title="${movie.getMovieName()}"
					actionJsp="/movie/entry_actions.jsp"
					cssClass="col-md-3 flex-item-break-xs card-row-padded"
					actionJspServletContext=application resultRow=row
					url="${viewMoviesURL}">

					<@liferay_frontend["vertical-card-footer"]>
						<p class="truncate-text flex-item-center">${movie.getDescription()}</p>
					</@>
				</@>
			</@>

			<liferay_ui["search-iterator"] markupView="lexicon" />
		</@>
	</div>
</div>