<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ATM Interface</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }
        h1 {
            text-align: center;
            margin-top: 50px;
        }
        form {
            width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin-bottom: 10px;
        }
        select, input[type="number"], input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
     <h1>Welcome to the ATM</h1>
    <form action="ATMServlet" method="post" id="atmForm">
        <label for="action">Select Action:</label>
        <select name="action" id="action" onchange="toggleAmountField()">
            <option value="withdraw">Withdraw</option>
            <option value="deposit">Deposit</option>
            <option value="checkBalance">Check Balance</option>
        </select><br>
        <div class="amount-field">
            <label for="amount" id="am">Enter Amount:</label>
            <input type="number" name="amount" id="amount" required><br>
        </div><br>
        <input type="submit" value="Submit">
    </form>

     <script>
        function toggleAmountField() {
        	var amountlabel = document.getElementById("am");
            var actionSelect = document.getElementById("action");
            var amountField = document.querySelector(".amount-field");
			var text = document.getElementById("amount");
			
            if (actionSelect.value === "checkBalance") {
                amountlabel.innerHTML="Enter Your PIN";
                text.type="password";
                text.style.width = "50%";
                text.style.height = "70%";
            } else {
                amountField.style.display = "block";
            }
        }
    </script>
</body>
</html>
