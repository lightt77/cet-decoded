import React from "react";

const dashboard = () => {
  return (
    <div className="Dashboard">
      {/* <div className="jumbotron">
        <h5>
          This is unplanned it really just happens. And maybe a little bush
          lives there. In your imagination you can go anywhere you want. No
          pressure. Just relax and watch it happen. Remember how free clouds
          are. They just lay around in the sky all day long. I want everbody to
          be happy. That's what it's all about. You can get away with a lot. Get
          tough with it, get strong. This is your world, whatever makes you
          happy you can put in it. Go crazy.
        </h5>
      </div> */}
      <div className='jumbotron'>
        {/* jdkjasld */}
        <img src="aaron-burden-QJDzYT_K8Xg-unsplash-scaled3.png" style={{maxWidth: '100%', height: 'auto'}}></img>
      </div>

      <div className="container">
        <div className='row'>
          <div className="card col-md-3 dashboardCards">
            <div className="card-body">
              <h5>Quants</h5>
              <a href='/sections/Quants' className='stretched-link'></a>
            </div>
          </div>

          <div className="card col-md-3 offset-md-1 dashboardCards">
            <div className="card-body">
              <h5>LR</h5>
              <a href='/sections/LR' className='stretched-link'></a>
            </div>
          </div>
          
          <div className="card col-md-3 offset-md-1 dashboardCards">
            <div className="card-body">
              <h5>Vocabulary</h5>
              <a href='/sections/Vocab' className='stretched-link'></a>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default dashboard;
