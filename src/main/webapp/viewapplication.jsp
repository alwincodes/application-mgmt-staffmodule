<html>
    <%@page import="com.sgca.model.Application"%>
 <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="styles/style.css" />
    <link rel="stylesheet" href="styles/navbar.css" />
    <link rel="stylesheet" href="styles/tabledesign.css" />
    <link rel="stylesheet" href="styles/search.css" />


    <link
      href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700&display=swap"
      rel="stylesheet"
    />

  <script defer src="javascript/theme.js"></script>
  </head>
  
  <body>
    <nav class="navbar">
      <ul class="navbar-nav">
        <li class="logo">
          <a href="#" class="nav-link">
            <span class="link-text logo-text">View</span>
            <svg
              aria-hidden="true"
              focusable="false"
              data-prefix="fad"
              data-icon="angle-double-right"
              role="img"
              xmlns="http://www.w3.org/2000/svg"
              viewBox="0 0 448 512"
              class="svg-inline--fa fa-angle-double-right fa-w-14 fa-5x"
            >
              <g class="fa-group">
                <path
                  fill="currentColor"
                  d="M224 273L88.37 409a23.78 23.78 0 0 1-33.8 0L32 386.36a23.94 23.94 0 0 1 0-33.89l96.13-96.37L32 159.73a23.94 23.94 0 0 1 0-33.89l22.44-22.79a23.78 23.78 0 0 1 33.8 0L223.88 239a23.94 23.94 0 0 1 .1 34z"
                  class="fa-secondary"
                ></path>
                <path
                  fill="currentColor"
                  d="M415.89 273L280.34 409a23.77 23.77 0 0 1-33.79 0L224 386.26a23.94 23.94 0 0 1 0-33.89L320.11 256l-96-96.47a23.94 23.94 0 0 1 0-33.89l22.52-22.59a23.77 23.77 0 0 1 33.79 0L416 239a24 24 0 0 1-.11 34z"
                  class="fa-primary"
                ></path>
              </g>
            </svg>
          </a>
        </li>
  
        <li class="nav-item">
          <a href="./application" class="nav-link">
            <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-card-text" viewBox="0 0 16 16">
              <path d="M14.5 3a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-13a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h13zm-13-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-13z"/>
              <path d="M3 5.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zM3 8a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9A.5.5 0 0 1 3 8zm0 2.5a.5.5 0 0 1 .5-.5h6a.5.5 0 0 1 0 1h-6a.5.5 0 0 1-.5-.5z"/>
            </svg>
            <span class="link-text">View</span>
          </a>
        </li>
  
        <li class="nav-item">
          <a href="./application?action=search" class="nav-link">
            <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
              <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
            </svg>
            <span class="link-text">Search</span>
          </a>
        </li>
  
        <li class="nav-item">
          <a href="./viewranklog.jsp" class="nav-link">
            <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-award" viewBox="0 0 16 16">
              <path d="M9.669.864L8 0 6.331.864l-1.858.282-.842 1.68-1.337 1.32L2.6 6l-.306 1.854 1.337 1.32.842 1.68 1.858.282L8 12l1.669-.864 1.858-.282.842-1.68 1.337-1.32L13.4 6l.306-1.854-1.337-1.32-.842-1.68L9.669.864zm1.196 1.193l.684 1.365 1.086 1.072L12.387 6l.248 1.506-1.086 1.072-.684 1.365-1.51.229L8 10.874l-1.355-.702-1.51-.229-.684-1.365-1.086-1.072L3.614 6l-.25-1.506 1.087-1.072.684-1.365 1.51-.229L8 1.126l1.356.702 1.509.229z"/>
              <path d="M4 11.794V16l4-1 4 1v-4.206l-2.018.306L8 13.126 6.018 12.1 4 11.794z"/>
            </svg>
            <span class="link-text">Rank</span>
          </a>
        </li>
  
        
  
        <li class="nav-item" >
          <a href="#" class="nav-link">
            <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-box-arrow-right" viewBox="0 0 16 16">
              <path fill-rule="evenodd" d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z"/>
              <path fill-rule="evenodd" d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
            </svg>
            <span class="link-text">Log Out</span>
          </a>
        </li>
      </ul>
    </nav>
    <div class="navbar-top">
      <span class=" themebtn" id="themeButton">Theme</span>
      <span class="username">Alwin007</span>
    </div>
    <main>
     <% Application info = (Application)request.getAttribute("individualdetails"); 
     System.out.println(info);
      if(info!= null){
      
      %>
      <h2 style="text-align: center;">Applicant Information</h2>
      <% if(info.getApplicationStatus().equals("submitted")){ %>
      <div class="btns">
        <a href="./application?action=accept&acceptid=<%=info.getId() %>" class="accept-link">Accept Student</a>
        <a href="./application?action=reject&rejectid=<%=info.getId() %>" class="reject-link">Reject Student</a>
      </div>
      <%} %>
    
      <div class="viewtablecontainer">
      <div class="tableview">
        <table class="maintable" border="1">
          <thead>
            <th colspan="2">Personal Details</th>
          </thead>
          <tr>
            <td>Name</td>
            <td><%=info.getStudName() %></td>
          </tr>
          <tr>
            <td>Sex</td>
            <td><%=info.getSex() %></td>
          </tr>
          <tr>
            <td>Physically Handicapped</td>
            <td><%=info.getHandicapped() %></td>
          </tr>
          <tr>
            <td>Address</td>
            <td><%=info.getAddress() %></td>
          </tr>
          <tr>
            <td>Pincode</td>
            <td><%=info.getPincode() %></td>
          </tr>
          <tr>
            <td>Phone Number</td>
            <td><%=info.getPhno() %></td>
          </tr>
          <tr>
            <td>Email</td>
            <td><%=info.getEmail() %></td>
          </tr>
        </table>
    </div>
    <div class="tableview">
      <table class="maintable" border="1">
        <thead>
          <th colspan="2">Community Details</th>
        </thead>
        <tr>
          <td>Religion and Caste</td>
          <td><%=info.getReligionCaste() %></td>
        </tr>
        <tr>
          <td>SC/ST/OBC/GEN</td>
          <td><%=info.getReligionCaste() %></td>
        </tr>
        <tr>
          <td>Anual Income</td>
          <td><%=info.getAnnualIncome() %></td>
        </tr>
        <thead>
          <th colspan="2">Extra Curricular Activities</th>
        </thead>
        <tr>
          <td>NCC/NSS</td>
          <td><%=info.getNccNss() %></td>
        </tr>
        <tr>
          <td>Sports/Games</td>
          <td><%=info.getSportsGames() %></td>
        </tr>
        <tr>
          <td>Literary/Cultural</td>
          <td><%=info.getLiteraryCultural() %></td>
        </tr>
      </table>
  </div>
  <div class="tableview">
    <table class="maintable" border="1">
    <thead>
        <th colspan="2">Educational Details</th>
      </thead>
      <tr>
        <td>Rank</td>
        <td><%=info.getStudentRank() %></td>
      </tr>
      <thead>
        <th colspan="2">Educational Details</th>
      </thead>
      <thead>
        <th colspan="2">SSLC</th>
      </thead>
      <tr>
        <td>DOB</td>
        <td><%=info.getDateOfBirth() %></td>
      </tr>
      <tr>
        <td>Register Number</td>
        <td><%=info.getSslcRegisNo() %></td>
      </tr>
      <tr>
        <td>Year & Month</td>
        <td><%=info.getSslcDate() %></td>
      </tr>
      <tr>
        <td>School</td>
        <td><%=info.getSslcSchool() %></td>
      </tr>
      <tr>
        <td>Board</td>
        <td><%=info.getSslcBoard() %></td>
      </tr>
      <thead>
        <th colspan="2">HSE</th>
      </thead>
      <tr>
        <td>Category</td>
        <td><%=info.getPlusTwoCat() %></td>
      </tr>
      <tr>
        <td>Year and Month</td>
        <td><%=info.getPlusTwoDate() %></td>
      </tr>
      <tr>
        <td>Register Number</td>
        <td><%=info.getPlusTwoRegNo() %></td>
      </tr>
      <tr>
        <td>School</td>
        <td><%=info.getPlusTwoSchool() %></td>
      </tr>
      <tr>
        <td>Board</td>
        <td><%=info.getPlusTwoBoard() %></td>
      </tr>
    </tr>
    </table>
 </div>
 <div class="tableview">
  <table class="maintable" border="1">
    <thead>
      <th colspan="2">Applicant Details</th>
    </thead>
    <tr>
      <td>MGU Application No</td>
      <td><%=info.getMguNumber() %></td>
    </tr>
    <tr>
      <td>Subject</td>
      <td><%=info.getSubject() %></td>
    </tr>
    <thead>
      <th colspan="2">Parent Details</th>
    </thead>
    <tr>
      <td>Name of Parent/Guardian</td>
      <td><%=info.getParentName() %></td>
    </tr>
    <tr>
      <td>Occupation</td>
      <td><%=info.getParentName() %></td>
    </tr>
    <tr>
      <td>Relationship</td>
      <td><%=info.getRelGuardian() %></td>
    </tr>
    <tr>
      <td>Annual Income</td>
      <td><%=info.getAnnualIncome() %></td>
    </tr>
  </table>
 </div>
 </div>
 <% } else { %>
    <h4>Invalid search</h4>
  <% } %>
    </main>
  </body>
</html>