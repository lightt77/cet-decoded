import React from 'react';

const navbar = () => {
  return (
    <div className="Navbar">
      <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <a id="navbarBrandName" className="navbar-brand" href="#">CetDecoded</a>
        <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor03" aria-controls="navbarColor03" aria-expanded="false" aria-label="Toggle navigation">
          <span className="navbar-toggler-icon"></span>
        </button>

        <div className="collapse navbar-collapse" id="navbarColor03">
          <ul className="navbar-nav mr-auto">
            <li className="nav-item">
              <a className="nav-link" href="#">Home</a>
            </li>
            <li className="nav-item dropdown">
              <a className="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Sections
              </a>
              <div className="dropdown-menu" aria-labelledby="navbarDropdown">
                <a className="dropdown-item" href="#">Quants</a>
                <a className="dropdown-item" href="#">LR</a>
                <a className="dropdown-item" href="#">Verbal</a>
              </div>
            </li>
            <li className="nav-item">
              <a className="nav-link" href="#">Articles</a>
            </li>
            <li className="nav-item">
              <a className="nav-link" href="#">Tests</a>
            </li>
            
          </ul>
        </div>
      </nav>
    </div>
  );
};

export default navbar;