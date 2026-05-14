<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Travelers - Administration Panel</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Helvetica Neue', Arial, sans-serif;
            background-color: #f5f7fa;
            color: #2d3748;
            font-size: 14px;
        }

        .container {
            display: flex;
            min-height: 100vh;
        }

        /* Sidebar */
        .sidebar {
            width: 64px;
            background: #ffffff;
            border-right: 1px solid #e2e8f0;
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 16px 0;
        }

        .logo {
            width: 40px;
            height: 40px;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            border-radius: 10px;
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
            font-weight: bold;
            margin-bottom: 32px;
        }

        .nav-icon {
            width: 40px;
            height: 40px;
            display: flex;
            align-items: center;
            justify-content: center;
            margin-bottom: 8px;
            border-radius: 8px;
            cursor: pointer;
            color: #718096;
            transition: all 0.2s;
        }

        .nav-icon:hover {
            background: #f7fafc;
            color: #667eea;
        }

        .nav-icon.active {
            background: #eef2ff;
            color: #667eea;
        }

        .version {
            margin-top: auto;
            color: #a0aec0;
            font-size: 12px;
        }

        /* Main Content */
        .main-content {
            flex: 1;
            padding: 24px;
        }

        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 24px;
        }

        .page-title {
            font-size: 24px;
            font-weight: 600;
            color: #1a202c;
        }

        .header-actions {
            display: flex;
            gap: 12px;
        }

        .btn {
            padding: 8px 16px;
            border-radius: 6px;
            border: 1px solid #e2e8f0;
            background: white;
            color: #4a5568;
            font-size: 14px;
            cursor: pointer;
            display: flex;
            align-items: center;
            gap: 8px;
            transition: all 0.2s;
        }

        .btn:hover {
            background: #f7fafc;
            border-color: #cbd5e0;
        }

        .btn-primary {
            background: #3182ce;
            color: white;
            border-color: #3182ce;
        }

        .btn-primary:hover {
            background: #2c5282;
        }

        /* Panel */
        .panel {
            background: white;
            border-radius: 8px;
            border: 1px solid #e2e8f0;
            overflow: hidden;
        }

        .panel-header {
            padding: 16px 20px;
            border-bottom: 1px solid #e2e8f0;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .live-info {
            color: #718096;
            font-size: 13px;
        }

        .live-info .live-badge {
            display: inline-flex;
            align-items: center;
            gap: 6px;
        }

        .live-dot {
            width: 8px;
            height: 8px;
            background: #48bb78;
            border-radius: 50%;
            animation: pulse 2s infinite;
        }

        @keyframes pulse {
            0%, 100% { opacity: 1; }
            50% { opacity: 0.5; }
        }

        .filter-controls {
            display: flex;
            gap: 8px;
            align-items: center;
        }

        .filter-select {
            padding: 8px 12px;
            border: 1px solid #e2e8f0;
            border-radius: 6px;
            background: white;
            color: #4a5568;
            font-size: 14px;
            min-width: 200px;
            cursor: pointer;
        }

        .filter-select:focus {
            outline: none;
            border-color: #667eea;
        }

        /* Table */
        .table-container {
            overflow-x: auto;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        thead {
            background: #f7fafc;
            border-bottom: 1px solid #e2e8f0;
        }

        th {
            padding: 12px 16px;
            text-align: left;
            font-weight: 600;
            color: #4a5568;
            font-size: 13px;
            text-transform: uppercase;
            letter-spacing: 0.5px;
            white-space: nowrap;
        }

        td {
            padding: 12px 16px;
            border-top: 1px solid #edf2f7;
            color: #2d3748;
            font-size: 14px;
        }

        tbody tr:hover {
            background: #f7fafc;
        }

        .filter-row {
            background: #fafbfc;
        }

        .filter-row td {
            padding: 8px 16px;
            border-top: 1px solid #e2e8f0;
            border-bottom: 1px solid #e2e8f0;
        }

        .filter-input {
            width: 100%;
            padding: 6px 8px;
            border: 1px solid #e2e8f0;
            border-radius: 4px;
            font-size: 13px;
            background: white;
        }

        .filter-input:focus {
            outline: none;
            border-color: #667eea;
        }

        .empty-state {
            text-align: center;
            padding: 48px 24px;
            color: #718096;
        }

        .empty-state-icon {
            font-size: 48px;
            margin-bottom: 16px;
            opacity: 0.5;
        }

        .status-badge {
            display: inline-flex;
            align-items: center;
            padding: 4px 8px;
            border-radius: 4px;
            font-size: 12px;
            font-weight: 500;
        }

        .status-active {
            background: #c6f6d5;
            color: #22543d;
        }

        .status-pending {
            background: #feebc8;
            color: #744210;
        }

        /* Icons */
        .icon {
            width: 16px;
            height: 16px;
            display: inline-block;
            vertical-align: middle;
        }
    </style>
</head>
<body>
    <div class="container">
        <!-- Sidebar -->
        <aside class="sidebar">
            <div class="logo">A</div>

            <a href="/">
                <div class="nav-icon" >
                    <svg width="20" height="20" viewBox="0 0 20 20" fill="currentColor">
                        <path d="M10 2a8 8 0 100 16 8 8 0 000-16zm0 14a6 6 0 110-12 6 6 0 010 12z"/>
                        <circle cx="10" cy="10" r="3"/>
                    </svg>
                </div>
            </a>

            <div class="nav-icon active">
                <svg width="20" height="20" viewBox="0 0 20 20" fill="currentColor">
                    <path d="M3 4a1 1 0 011-1h12a1 1 0 011 1v2a1 1 0 01-1 1H4a1 1 0 01-1-1V4zM3 10a1 1 0 011-1h6a1 1 0 011 1v6a1 1 0 01-1 1H4a1 1 0 01-1-1v-6zM14 9a1 1 0 00-1 1v6a1 1 0 001 1h2a1 1 0 001-1v-6a1 1 0 00-1-1h-2z"/>
                </svg>
            </div>
            
            <#--  <div class="nav-icon">
                <svg width="20" height="20" viewBox="0 0 20 20" fill="currentColor">
                    <path d="M4 4a2 2 0 00-2 2v1h16V6a2 2 0 00-2-2H4z"/>
                    <path d="M18 9H2v5a2 2 0 002 2h12a2 2 0 002-2V9zM4 13a1 1 0 011-1h1a1 1 0 011 1v1a1 1 0 01-1 1H5a1 1 0 01-1-1v-1zm5-1a1 1 0 011-1h1a1 1 0 011 1v1a1 1 0 01-1 1h-1a1 1 0 01-1-1v-1zm5 0a1 1 0 011-1h1a1 1 0 011 1v1a1 1 0 01-1 1h-1a1 1 0 01-1-1v-1z"/>
                </svg>
            </div>  -->
            
            <div class="version">1.1.0</div>
        </aside>

        <!-- Main Content -->
        <main class="main-content">
            <div class="header">
                <h1 class="page-title">Travelers</h1>
                
            </div>

            <div class="panel">
                
                     

                <div class="table-container">
                    <table>
                        <thead>
                            <tr>
                                <th>flightNumber</th>
                                <th>count</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                            
                            <#if flights?has_content>
                                <#list flights.flightModels() as flight>
                                    <tr>
                                        <td>${flight.flightNumber()!'-'}</td>
                                        <td>${flight.count()!'-'}</td>
                                        
            
                                    </tr>
                                </#list>
                            <#else>
                                <tr>
                                    <td colspan="11">
                                        <div class="empty-state">
                                            <div style="font-size: 16px; font-weight: 500; margin-bottom: 8px;">
                                                There are no records yet.
                                            </div>
                                            <div style="font-size: 13px; color: #a0aec0;">
                                                No travelers match your current filters
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </#if>
                        </tbody>
                    </table>
                </div>
            </div>
        </main>
    </div>


</body>
</html>