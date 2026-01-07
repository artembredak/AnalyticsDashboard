// ==================== TEMPERATURE (BAR) ====================
fetch("/api/charts/temperature")
    .then(res => res.json())
    .then(data => {
        const days = data.map(d => d.dayOfTheWeek);
        const temps = data.map(d => d.temperature);

        Plotly.newPlot("temperatureChart", [{
            x: days,
            y: temps,
            type: "bar"
        }], {
            margin: { t: 30 }
        });
    });


// ==================== MONTHLY SALES (BAR) ====================
fetch("/api/charts/monthly_sales")
    .then(res => res.json())
    .then(data => {
        const months = data.map(d => d.month);
        const sales = data.map(d => d.salesPln);

        Plotly.newPlot("salesChart", [{
            x: months,
            y: sales,
            type: "bar",
            marker: {
                color: '#3DB6B1'
            }
        }], {
            margin: { t: 30 }
        });
    });


// ==================== APP VISITS (PIE) ====================
fetch("/api/charts/app_visits")
    .then(res => res.json())
    .then(data => {
        const labels = data.map(d => d.sourceName);
        const values = data.map(d => d.percentage);

        Plotly.newPlot("visitsChart", [{
            labels: labels,
            values: values,
            type: "pie"
        }], {
            margin: { t: 30 }
        });
    });


// ==================== INVENTORY (PIE) ====================
fetch("/api/charts/inventory_storage")
    .then(res => res.json())
    .then(data => {
        const labels = data.map(d => d.productName);
        const values = data.map(d => d.percentage);

        const colors = ['#636EFA', '#EF553B', '#00CC96', '#AB63FA', '#FFA15A', '#19D3F3', '#FF6692'];

        const trace = {
            labels: labels,
            values: values,
            type: 'pie',
            textinfo: 'label+percent',   // показує і назву, і відсотки
            textposition: 'inside',      // текст всередині сегментів
            hole: 0.4,                   // робить Donut Chart
            marker: {
                colors: colors,
                line: {
                    color: '#fff',
                    width: 2
                }
            }
        };

        const layout = {
            margin: { t: 30 },
            showlegend: true,             // показує легенду
            legend: { x: 1, y: 0.5 }     // розташування легенди справа
        };

        Plotly.newPlot("inventoryChart", [trace], layout);
    });
///////////////

// ==================== USD (LINE) ====================
fetch("/api/charts/currency/usd")
    .then(res => res.json())
    .then(data => {
        Plotly.newPlot("usdChart", [{
            x: data.map(d => d.effectiveDate),
            y: data.map(d => d.mid),
            type: 'scatter',
            mode: 'lines+markers',
            name: 'USD'
        }], {
            margin: { t: 40 }
        });
    });

// ==================== CHF (LINE) ====================
fetch("/api/charts/currency/chf")
    .then(res => res.json())
    .then(data => {
        Plotly.newPlot("chfChart", [{
            x: data.map(d => d.effectiveDate),
            y: data.map(d => d.mid),
            type: 'scatter',
            mode: 'lines+markers',
            name: 'CHF'
        }], {
            margin: { t: 40 }
        });
    });
