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
            
            <div class="nav-icon active">
                <svg width="20" height="20" viewBox="0 0 20 20" fill="currentColor">
                    <path d="M10 2a8 8 0 100 16 8 8 0 000-16zm0 14a6 6 0 110-12 6 6 0 010 12z"/>
                    <circle cx="10" cy="10" r="3"/>
                </svg>
            </div>
            
            <div class="nav-icon">
                <svg width="20" height="20" viewBox="0 0 20 20" fill="currentColor">
                    <path d="M3 4a1 1 0 011-1h12a1 1 0 011 1v2a1 1 0 01-1 1H4a1 1 0 01-1-1V4zM3 10a1 1 0 011-1h6a1 1 0 011 1v6a1 1 0 01-1 1H4a1 1 0 01-1-1v-6zM14 9a1 1 0 00-1 1v6a1 1 0 001 1h2a1 1 0 001-1v-6a1 1 0 00-1-1h-2z"/>
                </svg>
            </div>
            
            <div class="nav-icon">
                <svg width="20" height="20" viewBox="0 0 20 20" fill="currentColor">
                    <path d="M4 4a2 2 0 00-2 2v1h16V6a2 2 0 00-2-2H4z"/>
                    <path d="M18 9H2v5a2 2 0 002 2h12a2 2 0 002-2V9zM4 13a1 1 0 011-1h1a1 1 0 011 1v1a1 1 0 01-1 1H5a1 1 0 01-1-1v-1zm5-1a1 1 0 011-1h1a1 1 0 011 1v1a1 1 0 01-1 1h-1a1 1 0 01-1-1v-1zm5 0a1 1 0 011-1h1a1 1 0 011 1v1a1 1 0 01-1 1h-1a1 1 0 01-1-1v-1z"/>
                </svg>
            </div>
            
            <div class="version">1.1.0</div>
        </aside>

        <!-- Main Content -->
        <main class="main-content">
            <div class="header">
                <h1 class="page-title">Travelers</h1>
                
                <div class="header-actions">
                    <button class="btn">
                        <svg width="16" height="16" viewBox="0 0 20 20" fill="currentColor">
                            <path fill-rule="evenodd" d="M3 17a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zm3.293-7.707a1 1 0 011.414 0L9 10.586V3a1 1 0 112 0v7.586l1.293-1.293a1 1 0 111.414 1.414l-3 3a1 1 0 01-1.414 0l-3-3a1 1 0 010-1.414z" clip-rule="evenodd"/>
                        </svg>
                        Export
                    </button>
                    <button class="btn">
                        <svg width="16" height="16" viewBox="0 0 20 20" fill="currentColor">
                            <path fill-rule="evenodd" d="M18 10a8 8 0 11-16 0 8 8 0 0116 0zM7 8a1 1 0 012 0v4a1 1 0 11-2 0V8zm5-1a1 1 0 00-1 1v4a1 1 0 102 0V8a1 1 0 00-1-1z" clip-rule="evenodd"/>
                        </svg>
                        Pause
                    </button>
                    <button class="btn">
                        <svg width="16" height="16" viewBox="0 0 20 20" fill="currentColor">
                            <path fill-rule="evenodd" d="M4 2a1 1 0 011 1v2.101a7.002 7.002 0 0111.601 2.566 1 1 0 11-1.885.666A5.002 5.002 0 005.999 7H9a1 1 0 010 2H4a1 1 0 01-1-1V3a1 1 0 011-1zm.008 9.057a1 1 0 011.276.61A5.002 5.002 0 0014.001 13H11a1 1 0 110-2h5a1 1 0 011 1v5a1 1 0 11-2 0v-2.101a7.002 7.002 0 01-11.601-2.566 1 1 0 01.61-1.276z" clip-rule="evenodd"/>
                        </svg>
                        Refresh
                    </button>
                </div>
            </div>

            <div class="panel">
                <div class="panel-header">
                    <#--  <div class="live-info">
                        <span class="live-badge">
                            <span class="live-dot"></span>
                            Live: 15 minutes
                        </span>
                        <span>• last <#if travelers??>${travelers?size}<#else>0</#if> rows (max 500)</span>
                    </div>  -->
                    
                    <div class="filter-controls">
                        <select class="filter-select">
                            <option>No filter selected</option>
                            <option>Active Travelers</option>
                            <option>Pending Verification</option>
                            <option>Last 24 Hours</option>
                        </select>
                        <button class="btn btn-primary">
                            <svg width="16" height="16" viewBox="0 0 20 20" fill="currentColor">
                                <path fill-rule="evenodd" d="M3 3a1 1 0 011-1h12a1 1 0 011 1v3a1 1 0 01-.293.707L12 11.414V15a1 1 0 01-.293.707l-2 2A1 1 0 018 17v-5.586L3.293 6.707A1 1 0 013 6V3z" clip-rule="evenodd"/>
                            </svg>
                            Filter
                        </button>
                        <button class="btn">
                            <svg width="16" height="16" viewBox="0 0 20 20" fill="currentColor">
                                <path fill-rule="evenodd" d="M11.49 3.17c-.38-1.56-2.6-1.56-2.98 0a1.532 1.532 0 01-2.286.948c-1.372-.836-2.942.734-2.106 2.106.54.886.061 2.042-.947 2.287-1.561.379-1.561 2.6 0 2.978a1.532 1.532 0 01.947 2.287c-.836 1.372.734 2.942 2.106 2.106a1.532 1.532 0 012.287.947c.379 1.561 2.6 1.561 2.978 0a1.533 1.533 0 012.287-.947c1.372.836 2.942-.734 2.106-2.106a1.533 1.533 0 01.947-2.287c1.561-.379 1.561-2.6 0-2.978a1.532 1.532 0 01-.947-2.287c.836-1.372-.734-2.942-2.106-2.106a1.532 1.532 0 01-2.287-.947zM10 13a3 3 0 100-6 3 3 0 000 6z" clip-rule="evenodd"/>
                            </svg>
                        </button>
                    </div>
                </div>

                <div class="table-container">
                    <table>
                        <thead>
                            <tr>
                                <th>id</th>
                                <th>sirname</th>
                                <th>documentCountry</th>
                                <th>documentType</th>
                                <th>documentNumber</th>
                                <th>fileName</th>
                                <th>fileType</th>
                                <th>fileDatetime</th>
                                <#--  <th>operation</th>
                                <th>ticketNumber</th>
                                <th>ata</th>  -->
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="filter-row">
                                <td colspan="11" style="padding: 0;">
                                    <div style="padding: 8px 16px; color: #718096; font-size: 13px;">
                                        Use this line to further filter the below items
                                    </div>
                                </td>
                            </tr>
                            
                            <#if travelerList?has_content>
                                <#list travelerList as traveler>
                                    <tr>
                                        <td>${traveler.id()!'-'}</td>
                                        <td>${traveler.sirname()!'-'}</td>
                                        <td>${traveler.documentCountry()!'-'}</td>
                                        <td>${traveler.documentType()!'-'}</td>
                                        <td>${traveler.documentNumber()!'-'}</td>
                                        <td>${traveler.fileName()!'-'}</td>
                                        <td>${traveler.fileType()!'-'}</td>
                                        <td>${traveler.fileDatetime()!'-'}</td>
                                        <#--  <td>${traveler.operation()!'-'}</td>
                                        <td>${traveler.ticketNumber()!'-'}</td>
                                        <td>${traveler.ata()!'-'}</td>  -->
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