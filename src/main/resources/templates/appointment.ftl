<!DOCTYPE html>

<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>Barbershop Demo</title>
  <link rel="stylesheet" type="text/css" href="/css/materialize.min.css"/>
  <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>

<body>
<div class="container">
  <div class="row">
    <div class="col s12 m12">
      <div class="card">
        <div class="card-content center">
          <div class="row">
            <h6 class="grey-text text-darken-4">Your appointment:</h6>
          </div>
          <div class="row">
            <div class="col s1 m1 l2"></div>
            <div class="form-label col s4 m4 l3">
              <label for="barberId">Barber</label>
            </div>
            <div class="input-field col s6 m6 l5">
              <input disabled id="barber" type="text" value="${appointment.barber.name}">
            </div>
            <div class="col s1 m1 l2"></div>
          </div>
          <div class="row">
            <div class="col s1 m1 l2"></div>
            <div class="form-label col s4 m4 l3">
              <label for="timeSlot">Time Slot</label>
            </div>
            <div class="input-field col s6 m6 l5">
              <input disabled id="timeSlot" type="text" value="${appointment.dateTime}">
            </div>
            <div class="col s1 m1 l2"></div>
          </div>
          <div class="row">
            <div class="col s1 m1 l2"></div>
            <div class="form-label col s4 m4 l3">
              <label for="clientName">Name</label>
            </div>
            <div class="input-field col s6 m6 l5">
              <input disabled id="clientName" type="text" value="${appointment.clientName}">
            </div>
            <div class="col s1 m1 l2"></div>
          </div>
          <div class="row">
            <div class="col s1 m1 l2"></div>
            <div class="form-label col s4 m4 l3">
              <label for="clientPhone">Phone</label>
            </div>
            <div class="input-field col s6 m6 l5">
              <input disabled id="clientPhone" type="text" value="${appointment.clientPhone}">
            </div>
            <div class="col s1 m1 l2"></div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="row center footer">
    <p>Created by John Smith <a href="mailto:john.smith@acme.com">john.smith@acme.com</a></p>
  </div>
</div>

<script src="/js/materialize.min.js"></script>

</body>
</html>